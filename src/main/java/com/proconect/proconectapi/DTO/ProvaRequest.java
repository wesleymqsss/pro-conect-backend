package com.proconect.proconectapi.DTO;

import java.time.LocalDate;
import java.util.List;

public record ProvaRequest(
        String descricao,
        LocalDate dataProva,
        Long materiaId,
        Long professorId,
        List<QuestaoRequest> questoes
) {}
