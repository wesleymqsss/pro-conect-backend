// src/main/java/com/proconect/proconectapi/model/Resposta.java
package com.proconect.proconectapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // quem respondeu
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    // a questão respondida
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questao_id", nullable = false)
    private questao questao;

    // a opção escolhida
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opcao_id", nullable = false)
    private Opcao opcao;

    // quando respondeu
    @Column(name = "data_resposta", nullable = false)
    private LocalDateTime dataResposta = LocalDateTime.now();

    // getters e setters

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public questao getQuestao() {
        return questao;
    }
    public void setQuestao(questao questao) {
        this.questao = questao;
    }

    public Opcao getOpcao() {
        return opcao;
    }
    public void setOpcao(Opcao opcao) {
        this.opcao = opcao;
    }

    public LocalDateTime getDataResposta() {
        return dataResposta;
    }
    public void setDataResposta(LocalDateTime dataResposta) {
        this.dataResposta = dataResposta;
    }
}
