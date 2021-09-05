package com.lucas.chain_of_responsibility.imccalculo;

import com.lucas.chain_of_responsibility.model.IMC;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IMCCalculoTest {

    private IMC imc;

    @Test
    public void calcularMagresa() {
        imc = new IMC(51, 1.81);
        assertResult(imc, "Magresa");
    }

    @Test
    public void calcularNormal() {
        imc = new IMC(81, 1.81);
        assertResult(imc, "Normal");
    }

    @Test
    public void calcularSobrepeso() {
        imc = new IMC(95, 1.81);
        assertResult(imc, "Sobrepeso");
    }

    @Test
    public void calcularObesidade() {
        imc = new IMC(120, 1.81);
        assertResult(imc, "Obesidade");
    }

    @Test
    public void calcularObesidadeGrave() {
        imc = new IMC(150, 1.81);
        assertResult(imc, "Obesidade grave");
    }

    public void assertResult(final IMC imc, final String resultadoEsperado){
        final String resultado = IMCCalculo.calcularImc(imc);
        assertEquals(resultadoEsperado, resultado);
    }
}
