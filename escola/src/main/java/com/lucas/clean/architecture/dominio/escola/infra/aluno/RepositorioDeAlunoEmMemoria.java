package com.lucas.clean.architecture.dominio.escola.infra.aluno;

import com.lucas.clean.architecture.dominio.escola.dominio.aluno.Aluno;
import com.lucas.clean.architecture.dominio.escola.dominio.aluno.AlunoException;
import com.lucas.clean.architecture.dominio.escola.dominio.aluno.CPF;
import com.lucas.clean.architecture.dominio.escola.dominio.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunoEmMemoria implements RepositorioDeAlunos {

    private List<Aluno> alunosMatriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.alunosMatriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return alunosMatriculados.stream()
                .filter(aluno -> aluno.getCpf().getNumero().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoException(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.alunosMatriculados;
    }
}
