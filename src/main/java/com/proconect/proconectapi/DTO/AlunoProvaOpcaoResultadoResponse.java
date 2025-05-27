package com.proconect.proconectapi.DTO;

// Cada opção dentro do resultado da questão
public record AlunoProvaOpcaoResultadoResponse(
        String rotulo,
        String descricao,
        Boolean correta
) {}