package com.lucas.loja;

import com.lucas.loja.imposto.CalculadoraImposto;
import com.lucas.loja.imposto.ICMS;
import com.lucas.loja.imposto.ISS;
import com.lucas.loja.orcamento.Orcamento;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class LojaApplication {

    public static void main(String[] args) {
//        SpringApplication.run(LojaApplication.class, args);
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        CalculadoraImposto calcularora = new CalculadoraImposto();

        System.out.println(calcularora.calcular(orcamento, new ISS()));
    }

}
