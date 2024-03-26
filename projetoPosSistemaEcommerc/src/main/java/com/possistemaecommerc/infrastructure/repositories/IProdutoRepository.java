package com.possistemaecommerc.infrastructure.repositories;

import com.possistemaecommerc.controllers.configuration.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto,Integer> {
}
