package com.possistemaecommerc.interfaces;

import com.possistemaecommerc.domain.Usuario;

public interface IUsuarioService {
    void criarConta(Usuario usuario);
    Usuario autenticar(String email, String senha);
    Usuario recuperarSenha(String email);
}
