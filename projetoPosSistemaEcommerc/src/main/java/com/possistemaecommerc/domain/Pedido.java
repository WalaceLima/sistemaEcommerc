package com.possistemaecommerc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPedido;

    @Column(nullable = false,unique = true)
    private String codigoPedido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataPedido;

    @Column(nullable = false)
    private Double valor;

    @ManyToOne//muitos Pedidos para 1 Cliente
//Chave estrangeira do relacionamento
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
     /*mapeamento da tabela associativa do banco de dados
     esta tabela ira conter chave estrangeira
        para pedido e para produto*/
    @JoinTable(
// nome da tabela associativa
            name = "itempedido",
// chave estrangeira com a tabela de Pedido
            joinColumns = @JoinColumn
                    (name = "idPedido", nullable = false),
// chave estrangeira com a tabela de Produto
            inverseJoinColumns = @JoinColumn
                    (name = "idProduto", nullable = false))
    private List<Produto> produtos;
}
