package com.proconect.proconectapi.DTO;

public class AlunoRespostaDTO {
    private Long id;
    private String nome;
    private String matricula;
    private String curso;
    private String turma;

    // Construtor com todos os campos
    public AlunoRespostaDTO(Long id, String nome, String matricula, String curso, String turma) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.turma = turma;
    }

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getTurma() { return turma; }
    public void setTurma(String turma) { this.turma = turma; }
}
