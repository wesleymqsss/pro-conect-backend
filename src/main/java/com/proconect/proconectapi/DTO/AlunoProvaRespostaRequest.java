package com.proconect.proconectapi.DTO;

import java.time.LocalDate;
import java.util.List;

// Requisição de envio de respostas pelo aluno
public record AlunoProvaRespostaRequest(
        Long provaId,
        Long alunoId,
        List<AlunoProvaQuestaoRespostaRequest> questoes
) {}