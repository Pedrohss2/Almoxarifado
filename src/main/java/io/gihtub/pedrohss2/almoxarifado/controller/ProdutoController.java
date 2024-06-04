package io.gihtub.pedrohss2.almoxarifado.controller;


import io.gihtub.pedrohss2.almoxarifado.dto.ProdutoDTO;
import io.gihtub.pedrohss2.almoxarifado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity<Void> procurarPorId(@RequestParam(name = "id", defaultValue = "") Long id) {
        produtoService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criar(@RequestBody ProdutoDTO produtoDTO) {

        produtoDTO = produtoService.criar(produtoDTO);

        URI cabecalho = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoDTO.getId())
                .toUri();

        return ResponseEntity.created(cabecalho).build();
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> atualizar(@RequestBody ProdutoDTO produtoDTO) {

        produtoDTO = produtoService.atualizar(produtoDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(Long id) {
        produtoService.delete(id);

        return ResponseEntity.notFound().build();
    }

}
