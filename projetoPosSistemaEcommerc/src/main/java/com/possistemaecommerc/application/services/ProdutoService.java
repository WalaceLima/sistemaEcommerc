package com.possistemaecommerc.application.services;

import com.possistemaecommerc.application.dtos.commands.ProdutoCreateCommand;
import com.possistemaecommerc.application.dtos.commands.ProdutoDeleteCommand;
import com.possistemaecommerc.application.dtos.commands.ProdutoUpdateCommand;
import com.possistemaecommerc.application.dtos.produtos.ProdutosDTO;
import com.possistemaecommerc.controllers.configuration.domain.Produto;
import com.possistemaecommerc.infrastructure.repositories.ICategoriaRepository;
import com.possistemaecommerc.infrastructure.repositories.IProdutoRepository;
import com.possistemaecommerc.infrastructure.repositories.IProdutosCache;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    private IProdutosCache produtosCache;

    @Autowired
    private ModelMapper modelMapper;

    public ProdutosDTO create(ProdutoCreateCommand command) {

        Produto produto = modelMapper.map(command, Produto.class);
        produto.setCategoria(categoriaRepository.findById(command.getIdCategoria()).get());
        produtoRepository.save(produto);
        ProdutosDTO dto = modelMapper.map(produto, ProdutosDTO.class);

        return dto;
    }

    public ProdutosDTO update(ProdutoUpdateCommand command) {

        Produto produto = produtoRepository.findById(command.getId()).get();

        produto.setNome(command.getNome());
        produto.setPreco(command.getPreco());
        produto.setQuantidade(command.getQuantidade());
        produto.setCategoria(categoriaRepository.findById(command.getIdCategoria()).get());

        produtoRepository.save(produto);
        ProdutosDTO dto = modelMapper.map(produto, ProdutosDTO.class);

        return dto;
    }

    public ProdutosDTO delete(ProdutoDeleteCommand command) {

        Produto produto = produtoRepository.findById(command.getId()).get();

        produtoRepository.delete(produto);
        ProdutosDTO dto = modelMapper.map(produto, ProdutosDTO.class);

        return dto;
    }

    public List<Produto> findAll() {

        return produtosCache.findAll();
    }

    public Produto findById(Integer id) {
        return produtosCache.findById(id).get();
    }

}