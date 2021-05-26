package com.lucas.escola;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {

    @Test
    public void naoDeveCriarCPF() {
        assertThrows(IllegalArgumentException.class, () -> new CPF("12345678901"));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF(" "));
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
    }

    @Test
    public void deveCriarCPF(){
        final CPF cpf = new CPF("123.456.789-10");

        assertNotNull(cpf);
        assertEquals("123.456.789-10", cpf.getNumero());
    }
}