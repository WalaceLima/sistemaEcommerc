package com.possistemaecommerc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAuth;
    private String email;
    private String senha;
}
