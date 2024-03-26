
package com.possistemaecommerc.application.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProdutoDTO {

    private String nome;
    private BigDecimal preco;
    private Integer quantidade;
}

