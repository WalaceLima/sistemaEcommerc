package com.possistemaecommerc.controllers.configuration.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(length = 250, nullable = false)
    private String descricao;

    @Column(length = 250, nullable = false)
    private Integer quantidade;

    /*
     * Nome do atributo na classe Pedido
     * onde foi mapeado a @JoinTable
     */
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "idProduto", nullable = false)
    private Categoria categoria;
}
