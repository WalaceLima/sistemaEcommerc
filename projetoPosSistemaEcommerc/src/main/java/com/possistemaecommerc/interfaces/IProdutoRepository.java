package com.possistemaecommerc.interfaces;

import com.possistemaecommerc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto,Integer> {
}
