package com.lucas.clean.architecture.dominio.escola.aplicacao.indicacao.aluno.matricular;

import com.lucas.clean.architecture.dominio.escola.dominio.aluno.Aluno;
import com.lucas.clean.architecture.dominio.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;

    public MatricularAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    //COMMAND
    public void executar(MatricularAlunoDto dados) {
        Aluno aluno = dados.criarAluno();
        repositorio.matricular(aluno);
    }
}
