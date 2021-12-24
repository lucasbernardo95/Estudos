package com.lucas.clean.architecture.dominio.escola.dominio.aluno;

import lombok.Data;

@Data
public class Email {

    //VALUE OBJECT
    private String endereco;

    public Email(String endereco) {
        if(endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            throw new IllegalArgumentException("E-mail inválido!");

        this.endereco = endereco;
    }
}
