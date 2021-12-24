package com.lucas.chain_of_responsibility.imccalculo;

import com.lucas.chain_of_responsibility.imcbase.*;
import com.lucas.chain_of_responsibility.model.IMC;

public class IMCCalculo {

    public static String calcularImc(IMC imc) {
        IMCMagresa magro = new IMCMagresa();
        IMCNormal normal = new IMCNormal();
        IMCSobrePeso sobrePeso = new IMCSobrePeso();
        IMCObesidade obeso = new IMCObesidade();
        IMCObesidadeGrave grave = new IMCObesidadeGrave();

        magro.setProximo(normal);
        normal.setProximo(sobrePeso);
        sobrePeso.setProximo(obeso);
        obeso.setProximo(grave);

        return magro.calcular(imc);
    }

}
