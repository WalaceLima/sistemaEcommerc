package com.possistemaecommerc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEndereco;

    @Column(length = 250, nullable = false)
    private String logradouro;

    @Column(length = 25, nullable = false)
    private String numero;

    @Column(length = 150, nullable = false)
    private String complemento;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(length = 100, nullable = false)
    private String cidade;

    @Column(length = 50, nullable = false)
    private String estado;

    @Column(length = 8, nullable = false)
    private String cep;

    @OneToOne
//mapeaando a chave estrangeira, unique=true (um para um)
    @JoinColumn(name = "idCliente", nullable = false, unique = true)
    private Cliente cliente;
}
