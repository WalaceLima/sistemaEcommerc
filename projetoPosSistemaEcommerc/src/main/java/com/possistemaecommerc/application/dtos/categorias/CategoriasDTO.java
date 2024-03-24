package com.possistemaecommerc.application.dtos.Categorias;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CategoriasDto {
    @Id
    private Integer id;
    private String nome;
    private String descricao;
}
