package com.possistemaecommerc.application.interfaces;

import com.possistemaecommerc.application.dtos.AtualizarDadosResponseDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarDTO;
import com.possistemaecommerc.application.dtos.auth.AutenticarResponseDTO;
import com.possistemaecommerc.application.dtos.auth.RecuperarSenhaResponseDTO;
import com.possistemaecommerc.application.dtos.contas.AtualizarDadosDTO;
import com.possistemaecommerc.application.dtos.contas.CriarContaDTO;
import com.possistemaecommerc.application.dtos.contas.CriarContaResponseDTO;
import com.possistemaecommerc.application.dtos.contas.RecuperarSenhaDTO;

public interface IUsuarioAppService {
    CriarContaResponseDTO criarConta(CriarContaDTO dto);

    AutenticarResponseDTO autenticar(AutenticarDTO dto);

    RecuperarSenhaResponseDTO recuperarSenha(RecuperarSenhaDTO dto);

    AtualizarDadosResponseDTO atualizarDados(AtualizarDadosDTO dto);
}
