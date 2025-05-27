// src/main/java/com/proconect/proconectapi/model/AlunoNotaProva.java
package com.proconect.proconectapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "notas")
public class AlunoNotaProva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prova_id", nullable = false)
    private Prova prova;

    @Column(name = "nota", nullable = false, precision = 5, scale = 2)
    private BigDecimal valor;

    public AlunoNotaProva() {}

    public AlunoNotaProva(Aluno aluno, Prova prova, BigDecimal valor) {
        this.aluno = aluno;
        this.prova  = prova;
        this.valor  = valor;
    }

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Prova getProva() {
        return prova;
    }
    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
