package com.possistemaecommerc.application.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticarPostDTO {

    @Email(message = "Informe um endereço de email válido.")
    @NotBlank(message = "Email de acesso é obrigatório.")
    private String email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
            ,message = "A senha deve ter pelo menos 8 caracteres, uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
    @NotBlank(message = "Senha da acesso é obrigatória.")
    private String senha;
}
