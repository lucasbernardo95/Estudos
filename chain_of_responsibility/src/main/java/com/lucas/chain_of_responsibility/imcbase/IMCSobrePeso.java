package com.lucas.chain_of_responsibility.imcbase;

import com.lucas.chain_of_responsibility.model.IMC;

public class IMCSobrePeso implements IMCBase {

    private IMCBase proximo;

    @Override
    public String calcular(IMC imc) {
        double resultado = imc.getResult();
        if (resultado >= 25.0 && resultado < 29.9)
            return "Sobrepeso";

        return proximo.calcular(imc);
    }

    @Override
    public void setProximo(IMCBase proximo) {
        this.proximo = proximo;
    }
}