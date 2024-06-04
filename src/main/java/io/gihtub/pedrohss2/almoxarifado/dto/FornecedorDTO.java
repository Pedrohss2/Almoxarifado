package io.gihtub.pedrohss2.almoxarifado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FornecedorDTO {

    private Long id;
    private  String nome;
    private String contato;
    private String estado;

}
