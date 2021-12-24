package com.lucas.chain_of_responsibility.imcbase;

import com.lucas.chain_of_responsibility.model.IMC;

public class IMCNormal implements IMCBase {

    private IMCBase proximo;

    @Override
    public String calcular(IMC imc) {
        double resultado = imc.getResult();
        if (resultado > 18.5 && resultado <= 24.9)
            return "Normal";

        return proximo.calcular(imc);
    }

    @Override
    public void setProximo(IMCBase proximo) {
        this.proximo = proximo;
    }

}
