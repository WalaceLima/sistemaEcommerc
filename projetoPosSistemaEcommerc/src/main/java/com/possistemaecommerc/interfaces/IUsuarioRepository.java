package com.possistemaecommerc.interfaces;

import com.possistemaecommerc.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    //@Query("{email : ?0}")
    Optional<Usuario> findByEmail(String email);

   // @Query("{email: ?0,senha : ?1}")
    Optional<Usuario> findByEmailAndSenha(String email,String senha);
}
