package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.ProvaResponse;
import com.proconect.proconectapi.DTO.ProvaRequest;
import com.proconect.proconectapi.DTO.RespostasDetalhadasDTO;
import com.proconect.proconectapi.model.Prova;
import com.proconect.proconectapi.service.ProvaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/provas")
public class ProvaController {

    private final ProvaService service;

    public ProvaController(ProvaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProvaResponse> all() {
        return service.listAll().stream()
                .map(p -> new ProvaResponse(
                        p.getId(),
                        p.getDescricao(),
                        p.getDataProva(),
                        p.getMateria().getId(),
                        p.getProfessor().getId()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProvaResponse get(@PathVariable Long id) {
        Prova p = service.getById(id);
        return new ProvaResponse(
                p.getId(),
                p.getDescricao(),
                p.getDataProva(),
                p.getMateria().getId(),
                p.getProfessor().getId());
    }

    // NOVO endpoint para listar todas as provas de um professor
    @GetMapping("/professor/{professorId}")
    public List<ProvaResponse> getByProfessor(@PathVariable Long professorId) {
        return service.listByProfessor(professorId).stream()
                .map(p -> new ProvaResponse(
                        p.getId(),
                        p.getDescricao(),
                        p.getDataProva(),
                        p.getMateria().getId(),
                        p.getProfessor().getId()))
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProvaResponse create(@RequestBody ProvaRequest req) {
        Prova p = service.create(req);
        return new ProvaResponse(
                p.getId(),
                p.getDescricao(),
                p.getDataProva(),
                p.getMateria().getId(),
                p.getProfessor().getId());
    }

    @GetMapping("/detalhadas/{id}")
    public RespostasDetalhadasDTO.ProvaDetalhadaResponse getDetalhada(@PathVariable Long id) {
        Prova p = service.getByIdComQuestoes(id);  // Método que traz as coleções carregadas

        List<RespostasDetalhadasDTO.QuestaoResponse> questoes = p.getQuestoes().stream()
                .map(q -> new RespostasDetalhadasDTO.QuestaoResponse(
                        q.getId(),
                        q.getTexto(),
                        q.getValor(),
                        q.getProfessor().getId(),
                        q.getOpcoes().stream()
                                .map(o -> new RespostasDetalhadasDTO.OpcaoResponse(
                                        o.getId(),
                                        o.getRotulo(),
                                        o.getDescricao(),
                                        o.getCorreta()
                                )).toList()
                )).toList();

        return new RespostasDetalhadasDTO.ProvaDetalhadaResponse(
                p.getId(),
                p.getDescricao(),
                p.getDataProva(),
                p.getMateria().getId(),
                p.getProfessor().getId(),
                questoes
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
