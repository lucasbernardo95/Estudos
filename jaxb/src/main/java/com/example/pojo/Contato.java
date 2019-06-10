package com.example.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contato {

	private String nome;

	private String sexo;

	private int idade;

	private Endereco endereco;

	public Contato() {

	}

	public Contato(String nome, String sexo, int idade,

			Endereco endereco) {

		this.nome = nome;

		this.sexo = sexo;

		this.idade = idade;

		this.endereco = endereco;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}