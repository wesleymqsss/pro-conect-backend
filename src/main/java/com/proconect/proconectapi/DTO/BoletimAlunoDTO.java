package com.proconect.proconectapi.DTO;

public class BoletimAlunoDTO {

    private Long alunoId;
    private String alunoNome;
    private String matricula;
    private String curso;
    private String turma;
    private String materia;
    private Double mediaFinal;

    public BoletimAlunoDTO(Long alunoId, String alunoNome, String matricula, String curso, String turma, String materia, Double mediaFinal) {
        this.alunoId = alunoId;
        this.alunoNome = alunoNome;
        this.matricula = matricula;
        this.curso = curso;
        this.turma = turma;
        this.materia = materia;
        this.mediaFinal = mediaFinal;
    }

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }

    public String getAlunoNome() { return alunoNome; }
    public void setAlunoNome(String alunoNome) { this.alunoNome = alunoNome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getTurma() { return turma; }
    public void setTurma(String turma) { this.turma = turma; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public Double getMediaFinal() { return mediaFinal; }
    public void setMediaFinal(Double mediaFinal) { this.mediaFinal = mediaFinal; }
}
