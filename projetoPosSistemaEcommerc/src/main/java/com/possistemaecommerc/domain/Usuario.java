package com.possistemaecommerc.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Transient;


import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    private Instant dataHoraCriacao;
    private Instant dataHoraUltimaAlteracao;
    @Transient
    private String accessToken;
    @Transient
    private String novaSenha;
}
