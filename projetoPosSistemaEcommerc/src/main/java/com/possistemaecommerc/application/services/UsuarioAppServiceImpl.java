package com.possistemaecommerc.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.possistemaecommerc.application.dtos.Conta.CriarContaDTO;
import com.possistemaecommerc.application.dtos.Conta.CriarContaResponseDTO;
import com.possistemaecommerc.application.dtos.Conta.RecuperarSenhaDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarResponseDTO;
import com.possistemaecommerc.application.dtos.auth.RecuperarSenhaResponseDTO;
import com.possistemaecommerc.domain.Usuario;
import com.possistemaecommerc.application.interfaces.IUsuarioAppService;
import com.possistemaecommerc.interfaces.IUsuarioDomainService;
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
        return null;
    }

    @Override
    public RecuperarSenhaResponseDTO recuperarSenha(RecuperarSenhaDTO dto) {
        return null;
    }
}
