package com.lucas.loja.imposto.strategy;

import com.lucas.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class ISS implements TipoImposto{

    public BigDecimal calcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.06"));
    }
}
