package com.lucas.clean.architecture.dominio.escola.aplicacao.indicacao.aluno.matricular;

import com.lucas.clean.architecture.dominio.escola.dominio.aluno.Aluno;
import com.lucas.clean.architecture.dominio.escola.dominio.aluno.CPF;
import com.lucas.clean.architecture.dominio.escola.dominio.aluno.Email;

public class MatricularAlunoDto {
    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno(){
        return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno));
    }
}
