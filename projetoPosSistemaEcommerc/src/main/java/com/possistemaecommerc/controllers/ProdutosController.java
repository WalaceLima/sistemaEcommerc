package com.possistemaecommerc.controllers;

import com.possistemaecommerc.application.dtos.commands.ProdutoCreateCommand;
import com.possistemaecommerc.application.dtos.commands.ProdutoDeleteCommand;
import com.possistemaecommerc.application.dtos.commands.ProdutoUpdateCommand;
import com.possistemaecommerc.application.dtos.produtos.ProdutosDTO;
import com.possistemaecommerc.application.services.ProdutoService;
import com.possistemaecommerc.controllers.configuration.domain.Produto;
import com.possistemaecommerc.infrastructure.repositories.IProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutosController {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutosDTO> post
            (@Valid @RequestBody ProdutoCreateCommand command) {
        return ResponseEntity.status(201)
                .body(produtoService.create(command));

    }

    @PutMapping
    public ResponseEntity<ProdutosDTO> put
            (@Valid @RequestBody ProdutoUpdateCommand command) {
        return ResponseEntity.status(200)
                .body(produtoService.update(command));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProdutosDTO> delete
            (@PathVariable("id") Integer id) {
        ProdutoDeleteCommand command = new ProdutoDeleteCommand();
        command.setId(id);
        return ResponseEntity.status(200)
                .body(produtoService.delete(command));

    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.status(200)
                .body(produtoService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> getById
            (@PathVariable("id") Integer id) {
        return ResponseEntity.status(200)
                .body(produtoService.findById(id));
    }
}
