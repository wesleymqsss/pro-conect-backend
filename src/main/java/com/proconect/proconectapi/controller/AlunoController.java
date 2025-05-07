package com.proconect.proconectapi.controller;


import com.proconect.proconectapi.model.Aluno;
import com.proconect.proconectapi.repository.AlunoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List <Aluno> getAllAlunos(){
        return alunoRepository.findAll();
    }
}
