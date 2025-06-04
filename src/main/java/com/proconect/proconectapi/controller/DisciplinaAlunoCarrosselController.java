package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.DisciplinaAlunoCarrosselDTO;
import com.proconect.proconectapi.model.DisciplinaAlunoCarrossel;
import com.proconect.proconectapi.repository.DisciplinaAlunoCarrosselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dashboard")
public class DisciplinaAlunoCarrosselController {

    @Autowired
    private DisciplinaAlunoCarrosselRepository repository;

    @GetMapping("/disciplinas-aluno")
    public List<DisciplinaAlunoCarrosselDTO> getDisciplinasAluno() {
        return repository.findAll().stream().map(ent ->
                new DisciplinaAlunoCarrosselDTO(
                        ent.getNomeDisciplina(),
                        ent.getIdProfessor(),       // ← já vem da view
                        ent.getProfessor(),
                        ent.getHorarioInicio(),
                        ent.getHorarioFim(),
                        ent.getSala(),
                        ent.getSituacao()
                )
        ).collect(Collectors.toList());
    }
}
