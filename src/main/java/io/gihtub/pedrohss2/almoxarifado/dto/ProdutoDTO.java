package io.gihtub.pedrohss2.almoxarifado.dto;

import io.gihtub.pedrohss2.almoxarifado.model.Fornecedor;
import io.gihtub.pedrohss2.almoxarifado.model.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Integer quantidade;
    private Fornecedor fornecedor_id;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.fornecedor_id = produto.getFornecedor();
    }

}
