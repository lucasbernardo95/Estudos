package com.lucas.rn.solid.service.reajuste;

import com.lucas.rn.solid.model.Funcionario;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
public class ReajusteService implements ValidacaoReajuste {

    private Set<ValidacaoReajuste> validacoes;

    @Override
    public void validar(Funcionario funcionario, BigDecimal aumento) {
        validacoes.forEach(validacao -> validacao.validar(funcionario, aumento));

        BigDecimal salarioAjustado = funcionario.getDadoPessoal().getSalario().add(aumento);
        funcionario.atualizarSalario(salarioAjustado);
    }

}
