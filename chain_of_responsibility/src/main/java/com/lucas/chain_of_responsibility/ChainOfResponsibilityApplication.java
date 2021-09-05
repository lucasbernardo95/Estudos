package com.lucas.chain_of_responsibility;

import com.lucas.chain_of_responsibility.imccalculo.IMCCalculo;
import com.lucas.chain_of_responsibility.model.IMC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class ChainOfResponsibilityApplication {

    public static void main(String[] args) {
        IMC imc = new IMC(84, 1.81);
        System.out.println(IMCCalculo.calcularImc(imc));
//        SpringApplication.run(ChainOfResponsibilityApplication.class, args);
    }

}
