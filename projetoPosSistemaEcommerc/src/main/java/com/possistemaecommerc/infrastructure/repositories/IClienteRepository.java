package com.possistemaecommerc.infrastructure.repositories;

import com.possistemaecommerc.controllers.configuration.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IClienteRepository extends JpaRepository<Cliente,Integer> {

    @Query("from Cliente c join c.endereco e where c.email=:pEmail")
    Cliente findByEmail(@Param("pEmail") String email);

    @Query("from Cliente c join c.endereco e where c.email=:pEmail and c.senha=:pSenha")
    Cliente findByEmailAndSenha(
            @Param("pEmail")String email,
            @Param("pSenha")String senha);
}
