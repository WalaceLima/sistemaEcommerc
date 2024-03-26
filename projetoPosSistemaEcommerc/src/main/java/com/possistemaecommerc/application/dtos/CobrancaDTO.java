package com.possistemaecommerc.application.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CobrancaDTO {
    private String numeroCartao;
    private String nomeImpressoNoCartao;
    private Integer mesValidade;
    private Integer anoValidade;
    private Integer codigoSeguranca;
    private BigDecimal valor;
}
