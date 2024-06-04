package io.gihtub.pedrohss2.almoxarifado.controller;


import io.gihtub.pedrohss2.almoxarifado.dto.FornecedorDTO;
import io.gihtub.pedrohss2.almoxarifado.dto.ProdutoDTO;
import io.gihtub.pedrohss2.almoxarifado.service.FornecedorService;
import io.gihtub.pedrohss2.almoxarifado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorDTO> criar(@RequestBody FornecedorDTO fornecedorDTO) {

        fornecedorDTO = fornecedorService.criar(fornecedorDTO);

        URI cabecalho = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(fornecedorDTO.getId())
                .toUri();

        return ResponseEntity.created(cabecalho).build();
    }

}
