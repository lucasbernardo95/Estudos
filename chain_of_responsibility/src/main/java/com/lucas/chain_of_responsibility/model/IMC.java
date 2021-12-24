package com.lucas.chain_of_responsibility.model;

public class IMC {

    private final double peso;
    private final double altura;

    public IMC(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public double getResult(){
        return peso / Math.pow(altura, 2);
    }
}
