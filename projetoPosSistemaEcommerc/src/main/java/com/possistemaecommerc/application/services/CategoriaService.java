package com.possistemaecommerc.application.services;

import com.possistemaecommerc.controllers.configuration.domain.Categoria;
import com.possistemaecommerc.infrastructure.repositories.ICategoriasCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private ICategoriasCache categoriasCache;

    public List<Categoria> findAll() {
        return categoriasCache.findAll();
    }
}
