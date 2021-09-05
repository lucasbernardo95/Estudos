package com.lucas.chain_of_responsibility.imcbase;

import com.lucas.chain_of_responsibility.model.IMC;

public class IMCMagresa implements IMCBase {

    private IMCBase proximo;

    @Override
    public String calcular(IMC imc) {
        double resultado = imc.getResult();
        if (resultado <= 18.5) {
            return "Magresa";
        }

        return proximo.calcular(imc);
    }

    @Override
    public void setProximo(IMCBase proximo) {
        this.proximo = proximo;
    }
}
