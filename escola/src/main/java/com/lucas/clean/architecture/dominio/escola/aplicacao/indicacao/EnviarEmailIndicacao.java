package com.lucas.clean.architecture.dominio.escola.aplicacao.indicacao;

import com.lucas.clean.architecture.dominio.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
    void enviarPara(Aluno indicado);
}
