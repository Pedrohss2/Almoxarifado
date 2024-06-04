package io.gihtub.pedrohss2.almoxarifado.service;

import io.gihtub.pedrohss2.almoxarifado.dto.ProdutoDTO;
import io.gihtub.pedrohss2.almoxarifado.model.Produto;
import io.gihtub.pedrohss2.almoxarifado.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;


    public ProdutoDTO procurarPorId(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado.."));

        return new ProdutoDTO(produto);
    }

    public ProdutoDTO criar(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);

        produto = produtoRepository.save(produto);

        return modelMapper.map(produto, ProdutoDTO.class);
    }

    public ProdutoDTO atualizar(ProdutoDTO produtoDTO) {
        try {
            Produto produto = modelMapper.map(produtoDTO, Produto.class);

            produto = produtoRepository.save(produto);

            return modelMapper.map(produto, ProdutoDTO.class);
        }
        catch (EntityNotFoundException erro) {
            throw new EntityNotFoundException(erro.getMessage());
        }

    }

    public void delete(Long id) {
        try {
            produtoRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException erro) {
            throw new EntityNotFoundException(erro.getMessage());
        }
    }

}
