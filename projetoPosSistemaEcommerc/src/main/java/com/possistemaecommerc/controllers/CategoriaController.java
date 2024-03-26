package com.possistemaecommerc.controllers;

import com.possistemaecommerc.application.services.CategoriaService;
import com.possistemaecommerc.controllers.configuration.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.status(200).body(categoriaService.findAll());
    }
}
