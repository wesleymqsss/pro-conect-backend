package com.proconect.proconectapi.DTO;

import java.util.List;

public record QuestaoRequest(
        String texto,
        Double valor,
        Long professorId,
        List<OpcaoRequest> opcoes
) {}
