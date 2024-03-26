package com.possistemaecommerc.application.dtos.contas;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AtualizarDadosDTO {


    @Min(value = 1, message = "Informe o ID do usuário.")
    private Integer idUsuario;

    @Size(min = 8, max = 150,
            message = "Nome do usuário deve ter de 8 a 150 caracteres.")
    private String nome;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "A senha deve ter pelo menos 8 caracteres,uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
    private String senha;
}
