package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.BoletimAlunoDTO;
import com.proconect.proconectapi.service.BoletimAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boletim")
@CrossOrigin(origins = "*")
public class BoletimAlunoController {

    @Autowired
    private BoletimAlunoService boletimAlunoService;

    @GetMapping
    public List<BoletimAlunoDTO> getBoletimAlunos() {
        return boletimAlunoService.getBoletimAlunos();
    }
}
