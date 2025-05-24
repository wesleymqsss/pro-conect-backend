package com.proconect.proconectapi.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questoes")
public class questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "texto", columnDefinition = "TEXT", nullable = false)
    private String texto;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prova_id", nullable = false)
    private Prova prova;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Opcao> opcoes = new HashSet<>();

    // getters e setters
    public Long getId() { return id; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public Prova getProva() { return prova; }
    public void setProva(Prova prova) { this.prova = prova; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public Set<Opcao> getOpcoes() { return opcoes; }
    public void setOpcoes(Set<Opcao> opcoes) { this.opcoes = opcoes; }
}
