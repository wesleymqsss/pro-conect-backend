package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.model.Aluno;
import com.proconect.proconectapi.repository.AlunoRepository;
import com.proconect.proconectapi.DTO.AlunoRespostaDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Retorna todos os alunos
    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    // Retorna alunos por turma (usando DTO)
    @GetMapping("/api/turma/{turma}")
    public ResponseEntity<List<AlunoRespostaDTO>> buscarAlunosPorTurma(@PathVariable String turma) {
        List<Aluno> alunos = alunoRepository.findByTurma(turma);
        List<AlunoRespostaDTO> alunosRespostaDTO = alunos.stream()
                .map(aluno -> new AlunoRespostaDTO(
                        aluno.getId(),
                        aluno.getNome(),
                        aluno.getMatricula(),
                        aluno.getCurso(),
                        aluno.getTurma()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(alunosRespostaDTO);
    }
}
