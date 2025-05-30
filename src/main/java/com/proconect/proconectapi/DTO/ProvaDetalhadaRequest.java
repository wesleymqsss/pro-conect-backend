package com.proconect.proconectapi.DTO;

import java.time.LocalDate;
import java.util.List;

public class ProvaDetalhadaRequest {
    public Long id;
    public String descricao;
    public LocalDate dataProva;
    public Long materiaId;
    public Long professorId;
    public List<QuestaoRequest> questoes;

    public static class QuestaoRequest {
        public Long id;
        public String texto;
        public Double valor;
        public Long professorId;
        public List<OpcaoRequest> opcoes;
    }

    public static class OpcaoRequest {
        public Long id;
        public String rotulo;
        public String descricao;
        public Boolean correta;
    }
}

