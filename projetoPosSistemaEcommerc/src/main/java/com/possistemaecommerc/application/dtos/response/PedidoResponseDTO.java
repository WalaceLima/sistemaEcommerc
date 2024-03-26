package com.possistemaecommerc.application.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoResponseDTO {
    private String status;
    private String numeroPedido;
    private String mensagem;

}
