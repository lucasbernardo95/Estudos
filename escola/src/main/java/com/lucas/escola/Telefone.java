package com.lucas.escola;

import lombok.Data;

@Data
public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(final String ddd, final String numero){

        if(ddd == null || !ddd.matches("\\d{2}"))
            throw new IllegalArgumentException("DDD inválido");

        if(numero == null || !numero.matches("\\d{8}|\\d{9}"))
            throw new IllegalArgumentException("Número inválido");


        this.ddd = ddd;
        this.numero = numero;
    }
}
