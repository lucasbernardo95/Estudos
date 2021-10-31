package com.lucas.loja.desconto.chain.of.responsability;

import com.lucas.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class DescontoPorQuantidadeMaiorCinco extends Desconto {

    public DescontoPorQuantidadeMaiorCinco(Desconto desconto) {
        super(desconto);
    }

    public BigDecimal calcular(Orcamento orcamento){
        if (orcamento.getQuantidadeItens() > 5)
            return orcamento.getValor().multiply(new BigDecimal("0.1"));

        return proximo.calcular(orcamento);
    }
}
