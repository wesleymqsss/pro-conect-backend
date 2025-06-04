package com.proconect.proconectapi.DTO;

public class DisciplinaAlunoCarrosselDTO {

    private String nomeDisciplina;
    private Long idProfessor;
    private String nomeProfessor;
    private String horarioInicio;
    private String horarioFim;
    private String sala;
    private String situacao;

    public DisciplinaAlunoCarrosselDTO() {}

    public DisciplinaAlunoCarrosselDTO(String nomeDisciplina, Long idProfessor, String nomeProfessor,
                                       String horarioInicio, String horarioFim, String sala, String situacao) {
        this.nomeDisciplina = nomeDisciplina;
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.sala = sala;
        this.situacao = situacao;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
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
