package com.lucas.loja.desconto.chain.of.responsability;

import com.lucas.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public abstract class Desconto {
    protected Desconto proximo; //Irá apontar para o próximo desconto

    public Desconto(Desconto desconto){
        this.proximo = desconto;
    }

    public abstract BigDecimal calcular(Orcamento orcamento);

}
