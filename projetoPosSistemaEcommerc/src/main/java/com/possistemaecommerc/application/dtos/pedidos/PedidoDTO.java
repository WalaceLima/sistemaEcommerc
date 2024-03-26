package com.possistemaecommerc.application.dtos.pedidos;

import com.possistemaecommerc.application.dtos.CobrancaDTO;
import com.possistemaecommerc.application.dtos.ProdutoDTO;
import com.possistemaecommerc.application.dtos.clientes.ClienteDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PedidoDTO {
    private BigDecimal valor;
    private ClienteDTO cliente;
    private CobrancaDTO cobranca;
    private List<ProdutoDTO> produtos;
}
