package com.possistemaecommerc.application.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AtualizarDadosResponseDTO {
    private String mensagem;
    private String id;
    private String nome;
    private String email;
}
