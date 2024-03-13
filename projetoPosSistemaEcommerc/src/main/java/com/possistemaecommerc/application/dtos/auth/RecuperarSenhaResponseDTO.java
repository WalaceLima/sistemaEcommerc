package com.possistemaecommerc.application.dtos.auth;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecuperarSenhaResponseDTO {
    private String mensagem;
    private String id;
    private String nome;
    private String email;
    private String accessToken;
}
