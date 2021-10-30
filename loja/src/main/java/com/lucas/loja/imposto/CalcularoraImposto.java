package com.lucas.loja.imposto;

import com.lucas.loja.imposto.enums.TipoImposto;
import com.lucas.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalcularoraImposto {

    public BigDecimal calcular(Orcamento orcamento, TipoImposto tipoImposto) {
        switch (tipoImposto){
            case ICMS:
                return orcamento.getValor().multiply(new BigDecimal("0.1"));
            case ISS:
                return orcamento.getValor().multiply(new BigDecimal("0.06"));
            default:
                return BigDecimal.ZERO;
        }
    }
}
