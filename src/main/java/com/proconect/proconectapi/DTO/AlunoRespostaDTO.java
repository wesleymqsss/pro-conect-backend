// src/main/java/com/proconect/proconectapi/dto/AlunoResposta.java
package com.proconect.proconectapi.DTO;

public class AlunoRespostaDTO {
    private Integer id;
    private String nome;
    private String matricula;
    private String curso;

    // getters e setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}
