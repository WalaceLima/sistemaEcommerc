package com.possistemaecommerc.api.controllers.configuration.domain.services;

import com.possistemaecommerc.application.dtos.AtualizarDadosResponseDTO;
import com.possistemaecommerc.application.dtos.contas.AtualizarDadosDTO;
import com.possistemaecommerc.application.dtos.contas.CriarContaDTO;
import com.possistemaecommerc.application.dtos.contas.CriarContaResponseDTO;
import com.possistemaecommerc.application.dtos.contas.RecuperarSenhaDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarResponseDTO;
import com.possistemaecommerc.application.dtos.auth.RecuperarSenhaResponseDTO;
import com.possistemaecommerc.application.interfaces.IUsuarioAppService;
import com.possistemaecommerc.infrastructure.MD5Component;
import com.possistemaecommerc.api.controllers.configuration.domain.Usuario;
import com.possistemaecommerc.infrastructure.repositories.IUsuarioDomainService;
import com.possistemaecommerc.infrastructure.repositories.IUsuarioRepository;
import com.possistemaecommerc.infrastructure.security.TokenSecurity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UsuarioServiceImplTODO implements IUsuarioAppService {
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    private IUsuarioDomainService usuarioDomainService;
    @Autowired
    private MD5Component md5Component;

    @Autowired
    private TokenSecurity tokenSecurity;

    @Override
    public CriarContaResponseDTO criarConta(CriarContaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();

        Usuario usuario=modelMapper.map(dto,Usuario.class);
        usuarioDomainService.criarConta(usuario);
        CriarContaResponseDTO criarContaResponseDTO=modelMapper.map(usuario,CriarContaResponseDTO.class);
        criarContaResponseDTO.setMensagem("Conta Criada com Sucesso.");

//        if(usuario.getEmail()==usuario.getEmail()){
//            throw  new IllegalArgumentException("O email informado já está cadastrado");
//        }
        usuario.setSenha(md5Component.encrypt(usuario.getSenha()));
        usuario.setDataHoraCriacao(Instant.now());
        usuario.getDataHoraUltimaAlteracao();
        iUsuarioRepository.save(usuario);

        return criarContaResponseDTO;
    }

    @Override
    public AutenticarResponseDTO autenticar(AutenticarDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = usuarioDomainService.autenticar(dto.getEmail(), dto.getSenha());

        AutenticarResponseDTO autenticarResponseDTO=modelMapper.map(usuario,AutenticarResponseDTO.class);
        autenticarResponseDTO.setMensagem("Usuário autenticado com sucesso.");

        return autenticarResponseDTO;
    }

    @Override
    public RecuperarSenhaResponseDTO recuperarSenha(RecuperarSenhaDTO dto) {
        return null;
    }

    @Override
    public AtualizarDadosResponseDTO atualizarDados(AtualizarDadosDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        Usuario usuarioAtualizado = usuarioDomainService
                .atualizarDados(usuario);
        AtualizarDadosResponseDTO response = modelMapper.map
                (usuarioAtualizado, AtualizarDadosResponseDTO.class);
        response.setMensagem("Usuário atualizado com sucesso.");
        return response;
    }


/*    @Override
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
    }*/
}
