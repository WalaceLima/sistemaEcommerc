package com.possistemaecommerc.application.dtos.auth;

import com.possistemaecommerc.application.dtos.clientes.ClienteGetDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticarGetDTO {
    private String mensagem;
    private String accessToken;
    private ClienteGetDTO cliente;
}
