package com.proconect.proconectapi.controller;

import com.proconect.proconectapi.DTO.DashBoardCardsDTO;
import com.proconect.proconectapi.model.DashBoardCardsModel;
import com.proconect.proconectapi.repository.DashboardCardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardCardsController {

    @Autowired
    private DashboardCardsRepository dashboardCardsRepository;

    @GetMapping("/api/cards")
    public ResponseEntity<?> getDashboardCards() {
        List<DashBoardCardsModel> data = dashboardCardsRepository.findAll();
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        DashBoardCardsModel result = data.get(0);

        List<DashBoardCardsDTO> response = Arrays.asList(
                new DashBoardCardsDTO("Total de Alunos", result.getTotalAlunos()),
                new DashBoardCardsDTO("Total de Turmas", result.getTotalTurmas()),
                new DashBoardCardsDTO("Total de Aprovados", result.getTotalAprovados()),
                new DashBoardCardsDTO("Total de Reprovados", result.getTotalReprovados())
        );

        return ResponseEntity.ok(response);
    }
}
