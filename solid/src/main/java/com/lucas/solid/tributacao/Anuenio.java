package com.lucas.solid.tributacao;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class Anuenio implements Reajuste {

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
}
