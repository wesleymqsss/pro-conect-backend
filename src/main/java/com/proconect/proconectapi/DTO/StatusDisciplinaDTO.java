package com.proconect.proconectapi.DTO;

public class StatusDisciplinaDTO {
    private String disciplina;
    private int aprovados;
    private int reprovados;
    private int recuperacao;

    public StatusDisciplinaDTO(String disciplina, int aprovados, int reprovados, int recuperacao) {
        this.disciplina = disciplina;
        this.aprovados = aprovados;
        this.reprovados = reprovados;
        this.recuperacao = recuperacao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public int getAprovados() {
        return aprovados;
    }

    public int getReprovados() {
        return reprovados;
    }

    public int getRecuperacao() {
        return recuperacao;
    }
}
