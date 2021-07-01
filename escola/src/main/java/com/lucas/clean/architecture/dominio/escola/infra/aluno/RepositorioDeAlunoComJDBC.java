package com.lucas.clean.architecture.dominio.escola.infra.aluno;

import com.lucas.clean.architecture.dominio.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunoComJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunoComJDBC(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {

            PreparedStatement prepare = connection.prepareStatement("INSERT INTO ALUNO VALUES(?, ?, ?)");
            prepare.setString(1, aluno.getNome());
            prepare.setString(2, aluno.getCpf().getNumero());
            prepare.setString(3, aluno.getEmail().getEndereco());
            prepare.execute();

            prepare = connection.prepareStatement("INSERT INTO TELEFONE VALUES(?, ?)");

            for(Telefone telefone : aluno.getTelefones()) {
                prepare.setString(1, telefone.getNumero());
                prepare.setString(2, telefone.getDdd());
                prepare.execute();
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {

        try {
            PreparedStatement prepared = connection.prepareStatement("SELECT id, nome, email FROM ALUNO WHERE cpf = ?");
            prepared.setString(1, cpf.getNumero());

            ResultSet result = prepared.executeQuery();
            if (result.next()) {
                throw new AlunoException(cpf);
            }

            final String nome = result.getString("nome");
            Email email = new Email(result.getNString("email"));
            Aluno aluno = new Aluno(cpf, nome, email);

            Long id = result.getLong("id");

            prepared = connection.prepareStatement("SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?");
            prepared.setLong(1, id);

            result = prepared.executeQuery();

            while (result.next()) {
                String numero = result.getNString("numero");
                String ddd = result.getNString("ddd");
            }

            return aluno;
        }  catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }

    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        try {
            PreparedStatement prepared = connection.prepareStatement("SELECT id, cpf, nome, email FROM ALUNO");
            ResultSet result = prepared.executeQuery();

            List<Aluno> alunos = new ArrayList<>();

            while(result.next()) {
                CPF cpf = new CPF(result.getString("cpf"));
                final String nome = result.getString("nome");
                Email email = new Email(result.getNString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = result.getLong("id");

                PreparedStatement preparedTelefone = connection.prepareStatement("SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?");
                preparedTelefone.setLong(1, id);

                ResultSet resultTelefone = prepared.executeQuery();

                while(resultTelefone.next()) {
                    final String numero = resultTelefone.getNString("numero");
                    final String ddd = resultTelefone.getNString("ddd");

                    aluno.adicionarTelefone(new Telefone(ddd, numero));
                }

                alunos.add(aluno);
            }

            return listarTodosAlunosMatriculados();
        } catch(SQLException exception){
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }
}
