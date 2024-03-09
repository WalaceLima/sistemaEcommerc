package com.possistemaecommerc.application.dtos.pedidos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoPostDTO {
    private String dataPedido;
    private String valor;
    private String idCliente;
    private Integer[] idProduto;

}
