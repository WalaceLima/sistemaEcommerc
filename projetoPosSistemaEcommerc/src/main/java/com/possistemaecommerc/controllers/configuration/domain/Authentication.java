package com.possistemaecommerc.controllers.configuration.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
