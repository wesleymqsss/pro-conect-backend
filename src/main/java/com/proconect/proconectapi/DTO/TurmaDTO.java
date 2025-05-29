package com.proconect.proconectapi.DTO;

public class TurmaDTO {
    private Long id;
    private String nome;
    private String curso;
    private String semestre;
    private String horarioInicio;
    private String horarioFim;

    public TurmaDTO(Long id, String nome, String curso, String semestre,
                    String horarioInicio, String horarioFim) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.semestre = semestre;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }

    // ======= AQUI OS GETTERS =======
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }
}
