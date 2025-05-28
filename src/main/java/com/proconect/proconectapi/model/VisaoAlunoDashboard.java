package com.proconect.proconectapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visaoalunodashboard")
public class VisaoAlunoDashboard {

    @Id
    private String tipo;
    private Integer value;

    public VisaoAlunoDashboard() {}

    public VisaoAlunoDashboard(String tipo, Integer value) {
        this.tipo = tipo;
        this.value = value;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
