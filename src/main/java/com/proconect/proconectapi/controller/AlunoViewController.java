package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.model.AlunoView;
import com.proconect.proconectapi.repository.AlunoViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin(origins = "*")
public class AlunoViewController {

    @Autowired
    private AlunoViewRepository repo;

    /** lista tudo: /api/alunos */
    @GetMapping
    public List<AlunoView> listarTodos() {
        return repo.findAll();
    }

    /** lista só um aluno: /api/alunos/{id} */
    @GetMapping("/{id}")
    public ResponseEntity<List<AlunoView>> buscarPorAluno(@PathVariable Long id) {
        List<AlunoView> lista = repo.findByAlunoId(id);
        if (lista.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }
}
