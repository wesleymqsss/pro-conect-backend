package com.proconect.proconectapi.DTO;

import java.time.LocalDate;
import java.util.List;

public class RespostasDetalhadasDTO {

    public record OpcaoResponse(
            Long id,
            String rotulo,
            String descricao,
            Boolean correta
    ) {}

    public record QuestaoResponse(
            Long id,
            String texto,
            Double valor,
            Long professorId,
            List<OpcaoResponse> opcoes
    ) {}

    public record ProvaDetalhadaResponse(
            Long id,
            String descricao,
            LocalDate dataProva,
            Long materiaId,
            Long professorId,
            List<QuestaoResponse> questoes
    ) {}
}
