package com.possistemaecommerc.interfaces;

import com.possistemaecommerc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEnderecoRepository extends JpaRepository<Endereco,Integer> {

}
