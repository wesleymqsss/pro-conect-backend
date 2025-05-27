package com.proconect.proconectapi.DTO;

import java.util.List;

// Cada questão respondida
public record AlunoProvaQuestaoRespostaRequest(
        Long questaoId,
        Long opcaoEscolhidaId
) {}