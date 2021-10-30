package com.lucas.loja.imposto;

import com.lucas.loja.orcamento.Orcamento;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class ISS implements TipoImposto{

    public BigDecimal calcular(@NotNull Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.06"));
    }
}
