package com.lucas.clean.architecture.dominio.escola;

import com.lucas.clean.architecture.dominio.escola.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    public void naoDeveriaCriarEmailComEndececosInvalidos(){
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email(" "));
        assertThrows(IllegalArgumentException.class, () -> new Email("email-invalido.com"));
        assertThrows(IllegalArgumentException.class, () -> new Email("email@"));
    }

    @Test
    public void deveCriarEmailValido(){
        final String endereco = "lucasbernardo95@gmail.com";
        final Email email = new Email(endereco);

        assertNotNull(email);
        assertEquals("lucasbernardo95@gmail.com", email.getEndereco());
    }
}