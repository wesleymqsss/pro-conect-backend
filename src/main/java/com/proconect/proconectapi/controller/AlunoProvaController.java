package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.*;
import com.proconect.proconectapi.model.Prova;
import com.proconect.proconectapi.service.AlunoProvaService;
import com.proconect.proconectapi.service.ProvaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping
public class AlunoProvaController {

    private final AlunoProvaService alunoProvaService;
    private final ProvaService provaService;

    public AlunoProvaController(AlunoProvaService alunoProvaService, ProvaService provaService) {
        this.alunoProvaService = alunoProvaService;
        this.provaService = provaService;
    }

    /**
     * POST /respostas → Aluno envia as respostas.
     */
    @PostMapping("/api/aluno/respostas")
    @ResponseStatus(HttpStatus.OK)
    public AlunoProvaResultadoResponse enviarRespostas(
            @RequestBody AlunoProvaRespostaRequest req) {
        return alunoProvaService.corrigirProva(req);
    }

    /**
     * GET /provas/{id} → Retorna prova sem gabarito para o aluno.
     */
    @GetMapping("/api/aluno/provas/{id}")
    public ProvaSemGabaritoDTO getProvaSemGabarito(@PathVariable Long id) {
        Prova prova = provaService.getByIdComQuestoes(id);

        var questoes = prova.getQuestoes().stream()
                .map(q -> new ProvaSemGabaritoDTO.Questao(
                        q.getId(),
                        q.getTexto(),
                        q.getValor().doubleValue(),
                        q.getOpcoes().stream()
                                .map(o -> new ProvaSemGabaritoDTO.Questao.Opcao(
                                        o.getId(),
                                        o.getRotulo(),
                                        o.getDescricao()
                                ))
                                .collect(Collectors.toList())
                )).collect(Collectors.toList());

        return new ProvaSemGabaritoDTO(
                prova.getId(),
                prova.getDescricao(),
                prova.getDataProva(),
                prova.getMateria().getId(),
                prova.getProfessor().getId(),
                questoes
        );
    }
}
