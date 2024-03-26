package com.possistemaecommerc.infrastructure.repositories;

import com.possistemaecommerc.application.dtos.produtos.ProdutosDTO;
import com.possistemaecommerc.controllers.configuration.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutosCache extends JpaRepository<Produto, Integer> {
}
