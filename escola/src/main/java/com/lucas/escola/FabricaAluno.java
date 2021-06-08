package com.lucas.escola;

import lombok.Getter;

@Getter
public class FabricaAluno {

    private Aluno aluno;

    public FabricaAluno comNomeCpfEmail(String nome, String cpf, String email){
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaAluno comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(new Telefone(ddd, numero));
        return this;
    }

    public Aluno gerar(){
        return this.aluno;
    }
}
