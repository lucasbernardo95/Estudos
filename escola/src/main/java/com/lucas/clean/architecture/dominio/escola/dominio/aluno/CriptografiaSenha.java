package com.lucas.clean.architecture.dominio.escola.dominio.aluno;

public interface CriptografiaSenha {

    String criptografia(String senha);

    boolean validarCriptografia(String senhaCriptografada, String senha);
}
