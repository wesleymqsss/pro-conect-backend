package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.StatusDisciplinaDTO;
import com.proconect.proconectapi.service.StatusDisciplinaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status-disciplinas")
public class StatusDisciplinaController {

    private final StatusDisciplinaService statusDisciplinaService;

    public StatusDisciplinaController(StatusDisciplinaService statusDisciplinaService) {
        this.statusDisciplinaService = statusDisciplinaService;
    }

    @GetMapping
    public List<StatusDisciplinaDTO> listarStatus() {
        return statusDisciplinaService.listarStatus();
    }
}
