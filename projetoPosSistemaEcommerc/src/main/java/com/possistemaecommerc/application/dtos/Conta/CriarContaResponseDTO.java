package com.possistemaecommerc.application.dtos.Conta;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CriarContaResponseDTO {
    private String mensagem;
    private String id;
    private String nome;
    private String email;
}
