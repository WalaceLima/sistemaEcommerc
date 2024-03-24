package com.possistemaecommerc.api.controllers.configuration.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduto;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(length = 250, nullable = false)
    private String descricao;

    @Column(length = 250, nullable = false)
    private String foto;
    /*
     * Nome do atributo na classe Pedido
     * onde foi mapeado a @JoinTable
     */
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "idCategoria", nullable = false)
    private Categoria categoria;
}
