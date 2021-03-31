package com.lucas.solid.tributacao;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class Promocao implements Reajuste, ReajusteTributavel {

    private BigDecimal valor;
    private LocalDate data;

    @Override
    public BigDecimal valor() {
        return valor;
    }

    @Override
    public LocalDate data() {
        return data;
    }

    @Override
    public BigDecimal valorImportoDeRenda() {
        return valor.multiply(new BigDecimal("0.1"));
    }
}
