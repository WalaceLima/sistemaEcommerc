package com.possistemaecommerc.domain.services;

import com.possistemaecommerc.infrastructure.MD5Component;
import com.possistemaecommerc.domain.Usuario;
import com.possistemaecommerc.interfaces.IUsuarioRepository;
import com.possistemaecommerc.interfaces.IUsuarioService;
import com.possistemaecommerc.infrastructure.security.TokenSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class UsuarioServiceImplTODO implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private MD5Component md5Component;

    @Autowired
    private TokenSecurity tokenSecurity;

    @Override
    public void criarConta(Usuario usuario) {

        Optional<Usuario> usuarioOptional=usuarioRepository.findByEmail(usuario.getEmail());

        if(usuarioOptional.isPresent()){
            throw  new IllegalArgumentException("O email informado já está cadastrado");
        }
        usuario.setSenha(md5Component.encrypt(usuario.getSenha()));
        usuario.setDataHoraCriacao(Instant.now());
        usuario.getDataHoraUltimaAlteracao();
        usuarioRepository.save(usuario);
    }


    @Override
    public Usuario autenticar(String email, String senha) {
        Optional<Usuario> optional = usuarioRepository
                .findByEmailAndSenha
                        (email, md5Component.encrypt(senha));
        if(optional.isEmpty()) {
            throw new IllegalArgumentException
                    ("Acesso negado. Usuário não encontrado.");
        }
        Usuario usuario = optional.get();
        usuario.setAccessToken(tokenSecurity.generateToken(usuario.getEmail()));

        return usuario;

    }

    @Override
    public Usuario recuperarSenha(String email) {
        return null;
    }
}
