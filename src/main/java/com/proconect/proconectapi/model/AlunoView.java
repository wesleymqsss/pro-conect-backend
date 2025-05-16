package com.proconect.proconectapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vw_notas_aluno")
@IdClass(AlunoView.class)
public class AlunoView {

    @Id
    @Column(name = "aluno_id")
    private Long alunoId;

    @Id
    private String materia;

    @Column(name = "aluno_nome")
    private String alunoNome;

    private String matricula;
    private String curso;

    @Column(name = "media_final")
    private BigDecimal mediaFinal;

    // getters e setters

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public String getAlunoNome() { return alunoNome; }
    public void setAlunoNome(String alunoNome) { this.alunoNome = alunoNome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public BigDecimal getMediaFinal() { return mediaFinal; }
    public void setMediaFinal(BigDecimal mediaFinal) { this.mediaFinal = mediaFinal; }
}
