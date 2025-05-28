package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.model.VisaoAlunoDashboard;
import com.proconect.proconectapi.repository.VisaoAlunoDashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisaoAlunoDashboardController {

    @Autowired
    private VisaoAlunoDashboardRepository repository;

    @GetMapping("api/dashboard/visao-alunos")
    public List<VisaoAlunoDashboard> getResumoDashboard() {
        return repository.findAll();
    }
}
