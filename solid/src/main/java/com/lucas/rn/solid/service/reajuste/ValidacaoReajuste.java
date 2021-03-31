package com.lucas.rn.solid.service.reajuste;

import com.lucas.rn.solid.model.Funcionario;

import java.math.BigDecimal;

public interface ValidacaoReajuste {
    void validar(Funcionario funcionario, BigDecimal aumento);
}
