package com.lucas.loja.desconto.chain.of.responsability;

import com.lucas.loja.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 *
 * calcular tem o objetivo de calcular o valor do desconto na aplicação do chain of responsability
 * então a classe semDesconto é uma forma de indicar a parada dos chamados dos 'próximas' verificações.
 * Então a aexecução irá iniciar com a verificação do desconto por quantidade de itens maiores que 5 e,
 * Caso o desconto não seja aplicado, irá chamar a verificação de desconto por valor maior que 500 e, caso
 * o desconto não seja aplicado, irá chamar o calcular do 'semDesconto' que irá finalizar as validações e
 * retornar zero;
 * Em caso do desconto ser aplicado, o calculo da classe responsável irá realizar o cálculo e retornar o valor.
 *
 **/

public class CalculadoraDesconto {

    public BigDecimal calcular(Orcamento orcamento) {
        var semDesconto = new SemDesconto();
        var descontoValor = new DescontoPorPrecoMaiorQueQuinhentos(semDesconto);
        var descontoQuantidade = new DescontoPorQuantidadeMaiorCinco(descontoValor);


        return descontoQuantidade.calcular(orcamento);
    }

}
