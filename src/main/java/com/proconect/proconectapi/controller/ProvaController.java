package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.*;
import com.proconect.proconectapi.model.Prova;
import com.proconect.proconectapi.service.ProvaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/provas")
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

    @PutMapping("/{id}")
    public ProvaResponse update(
            @PathVariable Long id,
            @RequestBody ProvaRequest req) {
        Prova p = service.update(id, req);
        return new ProvaResponse(
                p.getId(),
                p.getDescricao(),
                p.getDataProva(),
                p.getMateria().getId(),
                p.getProfessor().getId());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
