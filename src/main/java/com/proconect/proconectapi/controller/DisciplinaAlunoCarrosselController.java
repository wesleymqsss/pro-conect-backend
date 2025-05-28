package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.model.DisciplinaAlunoCarrossel;
import com.proconect.proconectapi.repository.DisciplinaAlunoCarrosselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DisciplinaAlunoCarrosselController {

    @Autowired
    private DisciplinaAlunoCarrosselRepository repository;

    @GetMapping("/disciplinas-aluno")
    public List<DisciplinaAlunoCarrossel> getDisciplinasAluno() {
        return repository.findAll();
    }
}
