/*
package com.possistemaecommerc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}
*/
