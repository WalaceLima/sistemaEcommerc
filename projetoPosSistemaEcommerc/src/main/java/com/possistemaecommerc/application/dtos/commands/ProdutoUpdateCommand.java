package com.possistemaecommerc.application.dtos.commands;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoUpdateCommand {

    @Min(value = 1, message = "Id do produto deve ser maior ou igual a 1.")
    private Integer id;

    @Size(min = 8, max = 150, message = "Nome deve ter de 8 a 100 caracteres.")
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @Size(min = 8, max = 150, message = "Descrição deve ter de 8 a 250 caracteres.")
    @NotBlank(message = "Descrição é obrigatório.")
    private String descricao;

    @Min(value = 1, message = "Preço deve ser maior ou igual a 1.")
    private BigDecimal preco;

    @Min(value = 1, message = "Quantidade deve ser maior ou igual a 1.")
    private Integer quantidade;

    @Min(value = 1, message = "Id da categoria deve ser maior ou igual a 1.")
    private Integer idCategoria;
}
