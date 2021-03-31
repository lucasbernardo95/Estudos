package com.lucas.rn.solid.service.reajuste;

import com.lucas.rn.solid.ValidacaoException;
import com.lucas.rn.solid.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidacaoPercentualReajuste implements ValidacaoReajuste {
    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        BigDecimal salarioAtual = funcionario.getSalario();

        BigDecimal percentualReajuste = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
        if (percentualReajuste.compareTo(new BigDecimal("0.4")) > 0)
            throw new ValidacaoException("Reajuste não pode ser superior a 40% do salário!");
    }
}
