package io.gihtub.pedrohss2.almoxarifado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movimentacao_produto")
public class MovimentacaoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "movimentacao_id")
    private Movimentacao movimentacao;

    private Integer quantidade;

    private Instant data;
}
