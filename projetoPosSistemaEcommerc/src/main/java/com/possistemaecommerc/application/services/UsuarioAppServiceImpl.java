package com.possistemaecommerc.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.possistemaecommerc.application.dtos.AtualizarDadosResponseDTO;
import com.possistemaecommerc.application.dtos.Conta.AtualizarDadosDTO;
import com.possistemaecommerc.application.dtos.Conta.CriarContaDTO;
import com.possistemaecommerc.application.dtos.Conta.CriarContaResponseDTO;
import com.possistemaecommerc.application.dtos.Conta.RecuperarSenhaDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarResponseDTO;
import com.possistemaecommerc.application.dtos.auth.RecuperarSenhaResponseDTO;
import com.possistemaecommerc.domain.Usuario;
import com.possistemaecommerc.application.interfaces.IUsuarioAppService;
import com.possistemaecommerc.interfaces.IUsuarioDomainService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioAppServiceImpl implements IUsuarioAppService {

    @Autowired
    private IUsuarioDomainService usuarioDomainService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public CriarContaResponseDTO criarConta(CriarContaDTO dto) {
        ModelMapper modelMapper= new ModelMapper();

        Usuario usuario= modelMapper.map(dto,Usuario.class);
        usuarioDomainService.criarConta(usuario);

        CriarContaResponseDTO responseDTO=modelMapper.map(usuario,CriarContaResponseDTO.class);
        responseDTO.setMensagem("Conta de usuário criada com sucesso.");
        return responseDTO;
    }

    @Override
    public AutenticarResponseDTO autenticar(AutenticarDTO dto) {

        ModelMapper modelMapper= new ModelMapper();
        Usuario usuario= usuarioDomainService.autenticar(dto.getEmail(), dto.getSenha());

        AutenticarResponseDTO autenticarResponseDTO=modelMapper.map(usuario,AutenticarResponseDTO.class);
        autenticarResponseDTO.setMensagem("Usuario autenticado com sucesso!");

        return autenticarResponseDTO;
    }

    @Override
    public RecuperarSenhaResponseDTO recuperarSenha(RecuperarSenhaDTO dto) {

        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = usuarioDomainService.recuperarSenha(dto.getEmail());
        RecuperarSenhaResponseDTO recuperarSenhaResponseDTO = modelMapper.map(usuario, RecuperarSenhaResponseDTO.class);
        recuperarSenhaResponseDTO.setMensagem("Recuperação de senha realizada com sucesso.");

        return recuperarSenhaResponseDTO;
    }

    @Override
    public AtualizarDadosResponseDTO atualizarDados(AtualizarDadosDTO dto) {
        return null;
    }
}
