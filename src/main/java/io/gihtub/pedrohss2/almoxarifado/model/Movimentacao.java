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

    @ManyToMany
    @JoinTable(name = "movimentacao_produto",
                joinColumns = @JoinColumn(name = "produto_id"),
                inverseJoinColumns = @JoinColumn(name = "movimentacao_id"))
    private Set<Produto> produto = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
