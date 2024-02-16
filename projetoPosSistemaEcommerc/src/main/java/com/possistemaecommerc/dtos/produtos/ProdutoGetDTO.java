package com.possistemaecommerc.dtos.produtos;

import com.possistemaecommerc.entities.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoGetDTO {
    private Integer idProduto;
    private String nome;
    private Double preco;
    private String descricao;
    private String foto;
    private Categoria categoria;
}
