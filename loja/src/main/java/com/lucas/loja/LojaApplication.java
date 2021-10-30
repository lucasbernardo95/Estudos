package com.lucas.loja;

import com.lucas.loja.imposto.CalcularoraImposto;
import com.lucas.loja.imposto.enums.TipoImposto;
import com.lucas.loja.orcamento.Orcamento;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class LojaApplication {

    public static void main(String[] args) {
//        SpringApplication.run(LojaApplication.class, args);
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        CalcularoraImposto calcularora = new CalcularoraImposto();

        System.out.println(calcularora.calcular(orcamento, TipoImposto.ISS));
    }

}
