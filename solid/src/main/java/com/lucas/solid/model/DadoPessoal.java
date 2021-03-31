package com.lucas.solid.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class DadoPessoal {

    private String nome;
    private String cpf;
    private Cargo cargo;
    private BigDecimal salario;

}
