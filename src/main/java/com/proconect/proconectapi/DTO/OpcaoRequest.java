package com.proconect.proconectapi.DTO;

public record OpcaoRequest(
        String rotulo,
        String descricao,
        Boolean correta
) {}
