package com.lucas.rn.solid.service.promocao;

import com.lucas.rn.solid.ValidacaoException;
import com.lucas.rn.solid.model.Cargo;
import com.lucas.rn.solid.model.Funcionario;

public class PromocaoReajuste {

    public void promover(Funcionario funcionario, boolean metaAtingida) {
        Cargo cargoAtual = funcionario.getCargo();

        if (Cargo.GERENTE == cargoAtual)
            throw new ValidacaoException("Gerentes não podem ser promovidos!");

        if (metaAtingida) {
            Cargo novoCargo = cargoAtual.getProximoCargo();
            funcionario.promover(novoCargo);
        } else {
            throw new ValidacaoException("Colaborador não atingiu a meta!");
        }
    }

}
