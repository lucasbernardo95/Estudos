package com.lucas.loja.imposto;

import com.lucas.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public interface TipoImposto {
    public BigDecimal calcular(Orcamento orcamento);
}
