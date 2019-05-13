package com.frontend.model;


import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String local;

    @NotEmpty
    //@Temporal(TemporalType.DATE)
    private String data;

    @NotEmpty
    private String horario;

    @OneToMany
    private List<Convidado> convidado;

    public Evento(String nome, String local, String data, String horario) {
        this.nome = nome;
        this.local = local;
        this.data = data;
        this.horario = horario;
    }

    public Evento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Convidado> getConvidado() {
        return convidado;
    }

    public void setConvidado(List<Convidado> convidado) {
        this.convidado = convidado;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                ", data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
