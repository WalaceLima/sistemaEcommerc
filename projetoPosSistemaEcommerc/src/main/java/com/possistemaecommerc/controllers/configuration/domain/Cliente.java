package com.possistemaecommerc.api.controllers.configuration.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCliente;

    @Column(length = 250, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(length = 13, nullable = false)
    private String telefone;

    @Column(length = 50, nullable = false)
    private String senha;

    /*
 Neste relacionamento devemos colocar o nome do atributo
da classe Endereco onde esta mapeado a chave
estrangeira com Cliente
na classe Endereco este atributo é:
[private Cliente cliente]
 O mappedBy deve fazer referencia ao nome
deste atributo
*/

//mapeaando a chave estrangeira, unique=true (um para um)
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Endereco endereco;
}
