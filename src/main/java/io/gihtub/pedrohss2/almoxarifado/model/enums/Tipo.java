package io.gihtub.pedrohss2.almoxarifado.model.enums;

import lombok.Getter;

@Getter
public enum Tipo {

    ENTRADA("entrada"),
    SAIDA("saida");

    private String getTipo;

    Tipo(String tipo) {
        this.getTipo = tipo;
    }
}
