package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.model.GraficoNota;
import com.proconect.proconectapi.repository.GraficoNotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GraficoNotaController {

    @Autowired
    private GraficoNotaRepository repository;

    @GetMapping("/api/dashboard/grafico-nota")
    public List<GraficoNota> getGraficoNota() {
        return repository.findAll();
    }
}
