package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.model.Nota;
import com.proconect.proconectapi.repository.NotaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nota")
public class NotaController {
    private final NotaRepository notaRepository;

    public NotaController(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @GetMapping
    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Integer id) {
        Optional<Nota> nota = notaRepository.findById(id);
        return nota.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Integer id) {
        if (notaRepository.existsById(id)) {
            notaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}