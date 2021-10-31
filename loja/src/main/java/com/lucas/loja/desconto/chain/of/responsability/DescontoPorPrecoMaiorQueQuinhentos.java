package com.lucas.loja.desconto.chain.of.responsability;

import com.lucas.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoPorPrecoMaiorQueQuinhentos extends Desconto{

    public DescontoPorPrecoMaiorQueQuinhentos(Desconto desconto) {
        super(desconto);
    }

    public BigDecimal calcular(Orcamento orcamento){
        if (orcamento.getValor().compareTo(new BigDecimal("500")) > 0)
            return orcamento.getValor().multiply(new BigDecimal("0.1"));

        return proximo.calcular(orcamento);
    }
}
