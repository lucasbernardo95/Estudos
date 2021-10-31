package com.lucas.loja;

import com.lucas.loja.desconto.chain.of.responsability.CalculadoraDesconto;
import com.lucas.loja.orcamento.Orcamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CalculadoraDescontoTest {

    @Test
    public void calcularDescontosQuantidadeMaiorQueCincoTest(){
        Orcamento porQuantidade = new Orcamento(new BigDecimal("200"), 6);

        CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();

        Assertions.assertEquals(calculadoraDesconto.calcular(porQuantidade), new BigDecimal("20.0"));
    }

    @Test
    public void calcularDescontosValaorMaiorQueQuinhentosTest(){
        Orcamento porValor = new Orcamento(new BigDecimal("1000"), 1);

        CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();

        Assertions.assertEquals(calculadoraDesconto.calcular(porValor), new BigDecimal("100.0"));
    }
}
