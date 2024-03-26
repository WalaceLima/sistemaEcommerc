package com.possistemaecommerc.application.dtos.produtos;


import com.possistemaecommerc.application.dtos.categorias.CategoriasDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutosDTO {

    private Integer idProduto;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;
    private CategoriasDTO categoria;
}
