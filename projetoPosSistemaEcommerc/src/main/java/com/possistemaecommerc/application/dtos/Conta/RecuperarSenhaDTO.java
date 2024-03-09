package com.possistemaecommerc.application.dtos.Conta;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class RecuperarSenhaDTO {

    @Email(message = "Informe um endereço de email válido.")
    @NotBlank(message = "Email de acesso é obrigatório.")
    private String email;
}
