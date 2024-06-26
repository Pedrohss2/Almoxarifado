package io.gihtub.pedrohss2.almoxarifado.model;


import io.gihtub.pedrohss2.almoxarifado.model.enums.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movimentacoes")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "movimentacao")
    private Set<MovimentacaoProduto> movimentacaoProdutos = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
