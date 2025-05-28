package com.proconect.proconectapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplinas_aluno_carrossel")
public class DisciplinaAlunoCarrossel {

    @Id
    @Column(name = "nome_disciplina")
    private String nomeDisciplina;

    @Column(name = "professor")
    private String professor;

    @Column(name = "horario_inicio")
    private String horarioInicio;

    @Column(name = "horario_fim")
    private String horarioFim;

    @Column(name = "sala")
    private String sala;

    @Column(name = "situacao")
    private String situacao;

    // Getters e Setters

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
