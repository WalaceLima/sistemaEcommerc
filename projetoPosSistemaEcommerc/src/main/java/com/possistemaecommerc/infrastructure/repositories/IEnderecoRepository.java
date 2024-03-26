package com.possistemaecommerc.infrastructure.repositories;

import com.possistemaecommerc.controllers.configuration.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEnderecoRepository extends JpaRepository<Endereco,Integer> {

}
