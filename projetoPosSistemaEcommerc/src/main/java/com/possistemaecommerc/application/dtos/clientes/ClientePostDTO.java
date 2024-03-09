package com.possistemaecommerc.application.dtos.clientes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePostDTO {
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String senha;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}
