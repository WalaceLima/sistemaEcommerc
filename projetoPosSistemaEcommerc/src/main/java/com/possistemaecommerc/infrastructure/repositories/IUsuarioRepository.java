package com.possistemaecommerc.infrastructure.repositories;

import com.possistemaecommerc.controllers.configuration.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    Optional<Usuario> findByEmail(String email);

   @Query("SELECT u FROM Usuario u WHERE u.email = ?1 AND u.senha = ?2")
    Optional<Usuario> findByEmailAndSenha(String email,String senha);
}
