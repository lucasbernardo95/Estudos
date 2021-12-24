package com.lucas.clean.architecture.dominio.escola.dominio.aluno;

import lombok.Data;

@Data
public class CPF {

    private String numero;

    public CPF(final String numero){

        if(numero == null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}"))
            throw new IllegalArgumentException("CPF inválido");

        this.numero = numero;
    }

}
