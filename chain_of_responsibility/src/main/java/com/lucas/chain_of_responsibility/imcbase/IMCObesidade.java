package com.lucas.chain_of_responsibility.imcbase;

import com.lucas.chain_of_responsibility.model.IMC;

public class IMCObesidade implements IMCBase {

    private IMCBase proximo;

    @Override
    public String calcular(IMC imc) {
        double resultado = imc.getResult();
        if (resultado >= 30.0 && resultado < 39.9)
            return "Obesidade";

        return proximo.calcular(imc);
    }

    @Override
    public void setProximo(IMCBase proximo) {
        this.proximo = proximo;
    }
}
