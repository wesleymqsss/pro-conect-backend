package com.proconect.proconectapi.DTO;

import java.time.LocalDate;
import java.util.List;

// Resposta final da prova para o aluno
public record   AlunoProvaResultadoResponse(
        String descricao,
        LocalDate dataProva,
        Long materiaId,
        Long professorId,
        Double nota,
        List<AlunoProvaQuestaoResultadoResponse> questoes
) {}