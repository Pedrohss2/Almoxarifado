package io.gihtub.pedrohss2.almoxarifado.service;

import io.gihtub.pedrohss2.almoxarifado.dto.FornecedorDTO;
import io.gihtub.pedrohss2.almoxarifado.dto.ProdutoDTO;
import io.gihtub.pedrohss2.almoxarifado.model.Fornecedor;
import io.gihtub.pedrohss2.almoxarifado.model.Produto;
import io.gihtub.pedrohss2.almoxarifado.repository.FornecedorRepository;
import io.gihtub.pedrohss2.almoxarifado.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FornecedorDTO criar(FornecedorDTO FornecedorDTO) {
        Fornecedor fornecedor = modelMapper.map(FornecedorDTO, Fornecedor.class);

        fornecedor = fornecedorRepository.save(fornecedor);

        return modelMapper.map(fornecedor, FornecedorDTO.class);
    }

}
