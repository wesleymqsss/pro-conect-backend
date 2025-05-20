package com.proconect.proconectapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "opcoes")
public class Opcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rotulo", length = 1, nullable = false)
    private String rotulo;

    @Column(name = "descricao", columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @Column(name = "correta", nullable = false)
    private Boolean correta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questao_id", nullable = false)
    private questao questao;

    // getters e setters
    public Long getId() { return id; }
    public String getRotulo() { return rotulo; }
    public void setRotulo(String rotulo) { this.rotulo = rotulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Boolean getCorreta() { return correta; }
    public void setCorreta(Boolean correta) { this.correta = correta; }
    public questao getQuestao() { return questao; }
    public void setQuestao(questao questao) { this.questao = questao; }
}
