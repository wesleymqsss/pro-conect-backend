package com.proconect.proconectapi.DTO;

import java.time.LocalDate;

public record ProvaResponse(
        Long id,
        String descricao,
        LocalDate dataProva,
        Long materiaId,
        Long professorId
) {}
