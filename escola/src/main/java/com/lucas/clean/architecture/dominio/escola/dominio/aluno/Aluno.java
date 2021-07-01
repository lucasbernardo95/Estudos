package com.lucas.clean.architecture.dominio.escola.dominio.aluno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    private String nome;
    private Email email;
    private CPF cpf;
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    private List<Telefone> telefones = new ArrayList<>();

    public void adicionarTelefone(Telefone telefone){
        this.telefones.add(telefone);
    }

}
