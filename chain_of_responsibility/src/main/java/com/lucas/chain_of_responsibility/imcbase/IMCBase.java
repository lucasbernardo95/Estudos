package com.lucas.chain_of_responsibility.imcbase;

import com.lucas.chain_of_responsibility.model.IMC;

public interface IMCBase {

    String calcular(IMC imc);

    void setProximo(IMCBase proximo);

}
