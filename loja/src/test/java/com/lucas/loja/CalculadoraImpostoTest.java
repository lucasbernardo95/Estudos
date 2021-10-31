package com.lucas.loja;

import com.lucas.loja.imposto.strategy.CalculadoraImposto;
import com.lucas.loja.imposto.strategy.ICMS;
import com.lucas.loja.imposto.strategy.ISS;
import com.lucas.loja.orcamento.Orcamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CalculadoraImpostoTest {

    @Test
    public void deveCalcularImpostoICMS() {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 5);
        CalculadoraImposto calcularora = new CalculadoraImposto();

        BigDecimal icms = calcularora.calcular(orcamento, new ICMS());
        Assertions.assertEquals(icms, new BigDecimal("10.0"));
    }

    @Test
    public void deveCalcularImpostoISS() {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
        CalculadoraImposto calcularora = new CalculadoraImposto();

        Assertions.assertEquals(calcularora.calcular(orcamento, new ISS()), new BigDecimal("6.00"));
    }

}
