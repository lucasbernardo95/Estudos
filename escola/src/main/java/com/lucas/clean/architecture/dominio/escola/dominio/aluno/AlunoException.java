package com.lucas.clean.architecture.dominio.escola.dominio.aluno;

public class AlunoException extends RuntimeException {
    public AlunoException(CPF cpf) {
        super("Aluno com CPF: " + cpf.getNumero() + " não encontrado.");
    }
}
