package com.lucas.rn.solid.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Funcionario {

    private DadoPessoal dadoPessoal;
    private LocalDate dataUltimoReajuste;

    public void atualizarSalario(BigDecimal salarioAjustado) {
        this.dadoPessoal.setSalario(salarioAjustado);
        this.dataUltimoReajuste = LocalDate.now();
    }

    public void promover(Cargo novoCargo) {
        this.dadoPessoal.setCargo(novoCargo);
    }

}
