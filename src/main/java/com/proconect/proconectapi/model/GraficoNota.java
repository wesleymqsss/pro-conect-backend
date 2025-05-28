package com.proconect.proconectapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grafico_nota")
public class GraficoNota {

    @Id
    @Column(name = "label")
    private String label;

    private int semestre1;
    private int semestre2;

    // Getters e Setters
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getSemestre1() {
        return semestre1;
    }

    public void setSemestre1(int semestre1) {
        this.semestre1 = semestre1;
    }

    public int getSemestre2() {
        return semestre2;
    }

    public void setSemestre2(int semestre2) {
        this.semestre2 = semestre2;
    }
}
