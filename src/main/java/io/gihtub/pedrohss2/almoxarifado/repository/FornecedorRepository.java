package io.gihtub.pedrohss2.almoxarifado.repository;

import io.gihtub.pedrohss2.almoxarifado.model.Fornecedor;
import io.gihtub.pedrohss2.almoxarifado.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
