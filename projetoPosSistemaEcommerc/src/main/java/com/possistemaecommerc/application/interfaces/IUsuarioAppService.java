package com.possistemaecommerc.application.interfaces;

import com.possistemaecommerc.application.dtos.auth.AutenticarResponseDTO;
import com.possistemaecommerc.application.dtos.Conta.CriarContaDTO;
import com.possistemaecommerc.application.dtos.Conta.CriarContaResponseDTO;
import com.possistemaecommerc.application.dtos.Conta.RecuperarSenhaDTO;
import com.possistemaecommerc.application.dtos.auth.RecuperarSenhaResponseDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarDTO;

public interface IUsuarioAppService {
    CriarContaResponseDTO criarConta(CriarContaDTO dto);
    AutenticarResponseDTO autenticar(AutenticarDTO dto);
    RecuperarSenhaResponseDTO recuperarSenha(RecuperarSenhaDTO dto);
}
