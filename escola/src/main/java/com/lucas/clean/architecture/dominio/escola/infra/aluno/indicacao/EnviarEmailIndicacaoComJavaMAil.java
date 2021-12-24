package com.lucas.clean.architecture.dominio.escola.infra.aluno.indicacao;

import com.lucas.clean.architecture.dominio.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import com.lucas.clean.architecture.dominio.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMAil implements EnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        // logica de envio de email com a lib Java Mail
    }
}
