package com.proconect.proconectapi.DTO;

public class DashBoardCardsDTO {
    private String tipo;
    private Long value;

    public DashBoardCardsDTO(String tipo, Long value) {
        this.tipo = tipo;
        this.value = value;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
