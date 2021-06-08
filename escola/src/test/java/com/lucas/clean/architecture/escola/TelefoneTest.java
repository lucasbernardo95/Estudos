package com.lucas.clean.architecture.escola;

import com.lucas.clean.architecture.escola.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    final String TELEFONE_VALIDO = "999884578";
    final String DDD_VALIDO = "84";

    @Test
    public void naoDeveCriarTelefone(){
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(" "," "));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("0", "123"));

        assertThrows(IllegalArgumentException.class, () -> new Telefone(DDD_VALIDO, ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(DDD_VALIDO, ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(DDD_VALIDO, ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(DDD_VALIDO, "0988756445"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(DDD_VALIDO, "8875644"));

        assertThrows(IllegalArgumentException.class, () -> new Telefone( "", TELEFONE_VALIDO));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, TELEFONE_VALIDO));
        assertThrows(IllegalArgumentException.class, () -> new Telefone(" ", TELEFONE_VALIDO));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("000", TELEFONE_VALIDO));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("0", TELEFONE_VALIDO));
    }

    @Test
    public void deveCriarTelefone(){
        final Telefone telefone = new Telefone(DDD_VALIDO, TELEFONE_VALIDO);

        assertNotNull(telefone);
        assertEquals("84",telefone.getDdd());
        assertEquals("999884578", telefone.getNumero());
    }

}