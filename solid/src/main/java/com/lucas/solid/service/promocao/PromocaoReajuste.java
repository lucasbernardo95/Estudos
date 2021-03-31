package com.lucas.solid.service.promocao;

import com.lucas.solid.ValidacaoException;
import com.lucas.solid.model.Cargo;
import com.lucas.solid.model.Funcionario;

public class PromocaoReajuste {

    public void promover(Funcionario funcionario, boolean metaAtingida) {
        Cargo cargoAtual = funcionario.getDadoPessoal().getCargo();;

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
