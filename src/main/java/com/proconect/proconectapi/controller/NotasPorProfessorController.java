package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.NotasPorProfessorDTO;
import com.proconect.proconectapi.service.NotasPorProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas-professor")
@CrossOrigin(origins = "*")
public class NotasPorProfessorController {

    @Autowired
    private NotasPorProfessorService service;

    @GetMapping
    public List<NotasPorProfessorDTO> listarNotas() {
        return service.listarNotas();
    }
}
