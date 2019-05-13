package com.frontend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Convidado {

    @Id
    @NotEmpty
    private String rg;

    @NotEmpty
    private String nome;

    @ManyToOne
    private Evento evento;

    public Convidado() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Convidado{" +
                "rg='" + rg + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
