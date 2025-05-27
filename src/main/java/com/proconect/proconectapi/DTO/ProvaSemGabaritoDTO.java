// src/main/java/com/proconect/proconectapi/DTO/ProvaSemGabaritoDTO.java
package com.proconect.proconectapi.DTO;

import java.time.LocalDate;
import java.util.List;

public record ProvaSemGabaritoDTO(
        Long id,
        String descricao,
        LocalDate dataProva,
        Long materiaId,
        Long professorId,
        List<Questao> questoes
) {
    public record Questao(
            Long id,
            String texto,
            Double valor,
            List<Opcao> opcoes
    ) {
        public record Opcao(
                Long id,
                String rotulo,
                String descricao
        ) {}
    }
}
