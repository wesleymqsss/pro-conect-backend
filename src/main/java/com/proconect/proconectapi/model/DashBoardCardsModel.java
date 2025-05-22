package com.proconect.proconectapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "vw_dashboard_summary")
public class DashBoardCardsModel {

    @Id
    private Long totalAlunos;
    private Long totalTurmas;
    private Long totalAprovados;
    private Long totalReprovados;

    // Getters e Setters

    public Long getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(Long totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    public Long getTotalTurmas() {
        return totalTurmas;
    }

    public void setTotalTurmas(Long totalTurmas) {
        this.totalTurmas = totalTurmas;
    }

    public Long getTotalAprovados() {
        return totalAprovados;
    }

    public void setTotalAprovados(Long totalAprovados) {
        this.totalAprovados = totalAprovados;
    }

    public Long getTotalReprovados() {
        return totalReprovados;
    }

    public void setTotalReprovados(Long totalReprovados) {
        this.totalReprovados = totalReprovados;
    }
}
