package com.possistemaecommerc.infrastructure.repositories;

import com.possistemaecommerc.controllers.configuration.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriasCache extends JpaRepository<Categoria,Integer> {
}
