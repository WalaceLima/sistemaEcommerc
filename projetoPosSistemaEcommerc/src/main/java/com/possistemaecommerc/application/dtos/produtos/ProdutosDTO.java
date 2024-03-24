package com.possistemaecommerc.application.dtos.produtos;


import com.possistemaecommerc.application.dtos.categorias.CategoriasDTO;
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
    private CategoriasDTO categoria;
}
