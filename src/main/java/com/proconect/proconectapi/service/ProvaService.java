package com.proconect.proconectapi.service;

import com.proconect.proconectapi.DTO.ProvaDetalhadaRequest;
import com.proconect.proconectapi.DTO.ProvaRequest;
import com.proconect.proconectapi.model.Opcao;
import com.proconect.proconectapi.model.Prova;
import com.proconect.proconectapi.model.questao;
import com.proconect.proconectapi.repository.MateriaRepository;
import com.proconect.proconectapi.repository.ProfessorRepository;
import com.proconect.proconectapi.repository.ProvaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProvaService {

    private final ProvaRepository provaRepo;
    private final MateriaRepository materiaRepo;
    private final ProfessorRepository professorRepo;

    public ProvaService(ProvaRepository provaRepo,
                        MateriaRepository materiaRepo,
                        ProfessorRepository professorRepo) {
        this.provaRepo = provaRepo;
        this.materiaRepo = materiaRepo;
        this.professorRepo = professorRepo;
    }

    @Transactional
    public Prova create(ProvaRequest req) {
        Prova p = new Prova();
        p.setDescricao(req.descricao());
        p.setDataProva(req.dataProva());
        p.setMateria(materiaRepo.findById(req.materiaId()).orElseThrow());
        p.setProfessor(professorRepo.findById(req.professorId()).orElseThrow());

        req.questoes().forEach(qr -> {
            questao q = new questao();
            q.setTexto(qr.texto());
            q.setValor(qr.valor());
            q.setProfessor(professorRepo.findById(qr.professorId()).orElseThrow());
            q.setProva(p);

            qr.opcoes().forEach(or -> {
                Opcao o = new Opcao();
                o.setRotulo(or.rotulo());
                o.setDescricao(or.descricao());
                o.setCorreta(or.correta());
                o.setQuestao(q);
                q.getOpcoes().add(o);
            });

            p.getQuestoes().add(q);
        });

        return provaRepo.save(p);
    }

    public Prova getById(Long id) {
        return provaRepo.findById(id).orElseThrow();
    }

    public List<Prova> listAll() {
        return provaRepo.findAll();
    }

    @Transactional
    public Prova update(Long id, ProvaRequest req) {
        Prova p = provaRepo.findById(id).orElseThrow();
        p.setDescricao(req.descricao());
        p.setDataProva(req.dataProva());
        p.setMateria(materiaRepo.findById(req.materiaId()).orElseThrow());
        p.setProfessor(professorRepo.findById(req.professorId()).orElseThrow());

        p.getQuestoes().clear();
        req.questoes().forEach(qr -> {
            questao q = new questao();
            q.setTexto(qr.texto());
            q.setValor(qr.valor());
            q.setProfessor(professorRepo.findById(qr.professorId()).orElseThrow());
            q.setProva(p);

            qr.opcoes().forEach(or -> {
                Opcao o = new Opcao();
                o.setRotulo(or.rotulo());
                o.setDescricao(or.descricao());
                o.setCorreta(or.correta());
                o.setQuestao(q);
                q.getOpcoes().add(o);
            });

            p.getQuestoes().add(q);
        });

        return provaRepo.save(p);
    }

    public void delete(Long id) {
        provaRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Prova getByIdComQuestoes(Long id) {
        return provaRepo.findByIdWithQuestoesEOpcoes(id)
                .orElseThrow(() -> new RuntimeException("Prova não encontrada"));
    }

    @Transactional(readOnly = true)
    public List<Prova> listByProfessor(Long professorId) {
        return provaRepo.buscarPorProfessor(professorId);
    }

    @Transactional
    public Prova upsert(ProvaRequest req) {
        Optional<Prova> existente = provaRepo.findByDescricaoAndDataProvaAndProfessorId(
                req.descricao(), req.dataProva(), req.professorId()
        );

        if (existente.isPresent()) {
            return update(existente.get().getId(), req);
        } else {
            return create(req);
        }
    }

    // Método para atualizar prova detalhada com o DTO ProvaDetalhadaRequest
    @Transactional
    public Prova updateDetalhada(Long id, ProvaDetalhadaRequest req) {
        Prova p = provaRepo.findById(id).orElseThrow();

        p.setDescricao(req.descricao);
        p.setDataProva(req.dataProva);
        p.setMateria(materiaRepo.findById(req.materiaId).orElseThrow());
        p.setProfessor(professorRepo.findById(req.professorId).orElseThrow());

        p.getQuestoes().clear();

        req.questoes.forEach(qr -> {
            questao q = new questao();
            // Se o model questao não tem setId, ignore essa linha:
            // q.setId(qr.id);
            q.setTexto(qr.texto);
            q.setValor(qr.valor);
            q.setProfessor(professorRepo.findById(qr.professorId).orElseThrow());
            q.setProva(p);

            qr.opcoes.forEach(or -> {
                Opcao o = new Opcao();
                // Se o model Opcao não tem setId, ignore essa linha:
                // o.setId(or.id);
                o.setRotulo(or.rotulo);
                o.setDescricao(or.descricao);
                o.setCorreta(or.correta);
                o.setQuestao(q);
                q.getOpcoes().add(o);
            });

            p.getQuestoes().add(q);
        });

        return provaRepo.save(p);
    }
}
