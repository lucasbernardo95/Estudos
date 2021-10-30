package com.lucas.loja.imposto;

import com.lucas.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraImposto {

    public BigDecimal calcular(Orcamento orcamento, TipoImposto tipoImposto) {
        return tipoImposto.calcular(orcamento);
    }
}
