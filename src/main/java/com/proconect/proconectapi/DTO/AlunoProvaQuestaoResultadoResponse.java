package com.proconect.proconectapi.DTO;

import java.util.List;

// Resultado de cada questão (inclui gabarito)
public record AlunoProvaQuestaoResultadoResponse(
        Long questaoId,
        String texto,
        Double valor,
        String respostaAluno,
        Boolean correta,
        List<AlunoProvaOpcaoResultadoResponse> opcoes
) {}