package com.possistemaecommerc.infrastructure.repositories;

import com.possistemaecommerc.controllers.configuration.domain.Usuario;

public interface IUsuarioService {
    void criarConta(Usuario usuario);
    Usuario autenticar(String email, String senha);
    Usuario recuperarSenha(String email);
}
