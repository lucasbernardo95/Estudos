package com.lucas.solid.service.reajuste;

import com.lucas.solid.ValidacaoException;
import com.lucas.solid.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class ValidacaoPeriodicidadeEntreReajuste implements ValidacaoReajuste {

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        LocalDate dataUltimoReajuste = funcionario.getDataUltimoReajuste();
        LocalDate dataAtual = LocalDate.now();

        if(Objects.nonNull(dataUltimoReajuste)) {
            long mesesUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
            if (mesesUltimoReajuste < 6)
                throw new ValidacaoException("Intervalo para reajuste deve ser de 6 meses.");
        }
    }

}
