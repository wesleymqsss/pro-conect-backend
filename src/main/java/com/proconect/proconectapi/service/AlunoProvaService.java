package com.proconect.proconectapi.service;

import com.proconect.proconectapi.DTO.*;
import com.proconect.proconectapi.model.*;
import com.proconect.proconectapi.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoProvaService {
    private final AlunoRepository alunoRepo;
    private final RespostaRepository respRepo;
    private final AlunoNotaProvaRepository notaRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public AlunoProvaService(AlunoRepository alunoRepo,
                             RespostaRepository respRepo,
                             AlunoNotaProvaRepository notaRepo) {
        this.alunoRepo = alunoRepo;
        this.respRepo = respRepo;
        this.notaRepo = notaRepo;
    }

    @Transactional
    public AlunoProvaResultadoResponse corrigirProva(AlunoProvaRespostaRequest req) {
        if (req == null || req.provaId() == null || req.alunoId() == null || req.questoes() == null) {
            throw new IllegalArgumentException("Dados de entrada inválidos");
        }

        Prova prova = carregarProvaComQuestoesEOpcoes(req.provaId());

        Aluno aluno = alunoRepo.findById(Math.toIntExact(req.alunoId()))
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Aluno não encontrado: " + req.alunoId()));

        // Verifica se o aluno já respondeu essa prova
        boolean jaRespondeu = notaRepo.existsByAlunoIdAndProvaId(aluno.getId(), prova.getId());
        if (jaRespondeu) {
            throw new IllegalStateException("O aluno já respondeu essa prova.");
        }

        double totalAluno = 0;
        double totalMaximo = 0;
        List<AlunoProvaQuestaoResultadoResponse> resultadosQuestoes = new ArrayList<>();

        for (questao questao : prova.getQuestoes()) {
            totalMaximo += questao.getValor().doubleValue();
        }

        for (AlunoProvaQuestaoRespostaRequest respostaQuestao : req.questoes()) {
            Optional<questao> questaoOpt = prova.getQuestoes().stream()
                    .filter(q -> q.getId().equals(respostaQuestao.questaoId()))
                    .findFirst();

            if (questaoOpt.isEmpty()) {
                throw new jakarta.persistence.EntityNotFoundException("Questão não encontrada: " + respostaQuestao.questaoId());
            }

            questao questao = questaoOpt.get();

            Optional<Opcao> opcaoEscolhidaOpt = questao.getOpcoes().stream()
                    .filter(o -> o.getId().equals(respostaQuestao.opcaoEscolhidaId()))
                    .findFirst();

            if (opcaoEscolhidaOpt.isEmpty()) {
                throw new jakarta.persistence.EntityNotFoundException("Opção não encontrada: " + respostaQuestao.opcaoEscolhidaId());
            }

            Opcao opcaoEscolhida = opcaoEscolhidaOpt.get();

            Resposta resposta = new Resposta();
            resposta.setAluno(aluno);
            resposta.setQuestao(questao);
            resposta.setOpcao(opcaoEscolhida);
            respRepo.save(resposta);

            boolean correta = Boolean.TRUE.equals(opcaoEscolhida.getCorreta());
            if (correta) {
                totalAluno += questao.getValor().doubleValue();
            }

            List<AlunoProvaOpcaoResultadoResponse> opcoes = questao.getOpcoes().stream()
                    .map(o -> new AlunoProvaOpcaoResultadoResponse(
                            o.getRotulo(),
                            o.getDescricao(),
                            o.getCorreta()
                    ))
                    .toList();

            resultadosQuestoes.add(new AlunoProvaQuestaoResultadoResponse(
                    questao.getId(),
                    questao.getTexto(),
                    questao.getValor().doubleValue(),
                    opcaoEscolhida.getRotulo(),
                    correta,
                    opcoes
            ));
        }

        double notaNormalizada = totalMaximo > 0 ? (totalAluno / totalMaximo) * 10.0 : 0;

        System.out.println("TOTAL ALUNO: " + totalAluno);
        System.out.println("TOTAL MAXIMO: " + totalMaximo);
        System.out.println("NOTA NORMALIZADA: " + notaNormalizada);

        BigDecimal notaBd = BigDecimal.valueOf(notaNormalizada).setScale(2, RoundingMode.HALF_UP);
        AlunoNotaProva alunoNota = new AlunoNotaProva(aluno, prova, notaBd);
        notaRepo.save(alunoNota);

        return new AlunoProvaResultadoResponse(
                prova.getDescricao(),
                prova.getDataProva(),
                prova.getMateria().getId(),
                prova.getProfessor().getId(),
                notaBd.doubleValue(),
                resultadosQuestoes
        );
    }

    private Prova carregarProvaComQuestoesEOpcoes(Long id) {
        TypedQuery<Prova> query = entityManager.createQuery("""
            SELECT DISTINCT p FROM Prova p
            LEFT JOIN FETCH p.questoes q
            LEFT JOIN FETCH q.opcoes
            WHERE p.id = :id
        """, Prova.class);
        query.setParameter("id", id);

        return query.getResultStream()
                .findFirst()
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Prova não encontrada com id: " + id));
    }
}
