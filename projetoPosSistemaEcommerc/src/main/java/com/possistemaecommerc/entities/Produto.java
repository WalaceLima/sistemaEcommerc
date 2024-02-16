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
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
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
    @JoinColumn(name = "idcategoria", nullable = false)
    private Categoria categoria;
}
