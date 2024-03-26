package com.possistemaecommerc.infrastructure.repositories;

import com.possistemaecommerc.controllers.configuration.domain.Usuario;

public interface IUsuarioDomainService {
    void criarConta(Usuario usuario);
    Usuario autenticar(String email, String senha);
    Usuario recuperarSenha(String email);
    Usuario atualizarDados(Usuario usuario);

}
