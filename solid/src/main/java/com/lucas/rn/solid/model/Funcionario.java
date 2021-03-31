package com.lucas.rn.solid.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class Funcionario {

    private String nome;
    private String cpf;
    private Cargo cargo;
    private BigDecimal salario;
    private LocalDate dataUltimoReajuste;

    public void atualizarSalario(BigDecimal salarioAjustado) {
        this.salario = salarioAjustado;
        this.dataUltimoReajuste = LocalDate.now();
    }

    public void promover(Cargo novoCargo) {
        this.cargo = novoCargo;
    }

}
