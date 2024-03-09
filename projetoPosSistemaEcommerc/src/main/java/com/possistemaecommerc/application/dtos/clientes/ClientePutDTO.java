package com.possistemaecommerc.application.dtos.clientes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientePutDTO {

    private Integer idCliente;
    private String nome;
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
