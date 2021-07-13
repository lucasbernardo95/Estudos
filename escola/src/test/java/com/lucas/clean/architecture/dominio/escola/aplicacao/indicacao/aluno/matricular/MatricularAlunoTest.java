package com.lucas.clean.architecture.dominio.escola.aplicacao.indicacao.aluno.matricular;

import com.lucas.clean.architecture.dominio.escola.dominio.aluno.Aluno;
import com.lucas.clean.architecture.dominio.escola.dominio.aluno.CPF;
import com.lucas.clean.architecture.dominio.escola.infra.aluno.RepositorioDeAlunoEmMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class MatricularAlunoTest {

    @Test
    void alunoDeveraSerPersistido() {
        RepositorioDeAlunoEmMemoria repositorio = new RepositorioDeAlunoEmMemoria();

        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDto dados = new MatricularAlunoDto("Aluno", "123.456.789-01", "aluno@email.com");

        useCase.executar(dados);

        final Aluno aluno = repositorio.buscarPorCPF(new CPF("123.456.789-01"));

        assertNotNull(aluno);
        assertEquals("Aluno", aluno.getNome());
        assertEquals("123.456.789-01", aluno.getCpf().getNumero());
        assertEquals("aluno@email.com", aluno.getEmail().getEndereco());
    }
}