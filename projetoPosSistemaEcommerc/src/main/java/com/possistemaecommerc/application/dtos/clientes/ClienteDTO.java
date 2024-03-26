package com.possistemaecommerc.application.dtos.clientes;

import com.possistemaecommerc.application.dtos.EnderecoDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private EnderecoDto endereco;
}
