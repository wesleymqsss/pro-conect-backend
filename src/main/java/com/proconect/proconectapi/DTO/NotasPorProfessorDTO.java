package com.proconect.proconectapi.DTO;

import java.time.LocalDate;

public class NotasPorProfessorDTO {

    private Long provaId;
    private String descricaoProva;
    private LocalDate dataProva;
    private Long professorId;
    private Long alunoId;
    private String alunoNome;
    private String matricula;
    private String curso;
    private String turma;
    private Double nota;

    public NotasPorProfessorDTO(Long provaId, String descricaoProva, LocalDate dataProva, Long professorId,
                                Long alunoId, String alunoNome, String matricula, String curso, String turma, Double nota) {
        this.provaId = provaId;
        this.descricaoProva = descricaoProva;
        this.dataProva = dataProva;
        this.professorId = professorId;
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
        this.matricula = matricula;
        this.curso = curso;
        this.turma = turma;
        this.nota = nota;
    }

    public Long getProvaId() { return provaId; }
    public String getDescricaoProva() { return descricaoProva; }
    public LocalDate getDataProva() { return dataProva; }
    public Long getProfessorId() { return professorId; }
    public Long getAlunoId() { return alunoId; }
    public String getAlunoNome() { return alunoNome; }
    public String getMatricula() { return matricula; }
    public String getCurso() { return curso; }
    public String getTurma() { return turma; }
    public Double getNota() { return nota; }

    public void setProvaId(Long provaId) { this.provaId = provaId; }
    public void setDescricaoProva(String descricaoProva) { this.descricaoProva = descricaoProva; }
    public void setDataProva(LocalDate dataProva) { this.dataProva = dataProva; }
    public void setProfessorId(Long professorId) { this.professorId = professorId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public void setAlunoNome(String alunoNome) { this.alunoNome = alunoNome; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setCurso(String curso) { this.curso = curso; }
    public void setTurma(String turma) { this.turma = turma; }
    public void setNota(Double nota) { this.nota = nota; }
}
