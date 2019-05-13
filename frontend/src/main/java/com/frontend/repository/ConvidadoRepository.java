package com.frontend.repository;

import com.frontend.model.Convidado;
import com.frontend.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvidadoRepository extends JpaRepository<Convidado, String> {

    public Iterable<Convidado> findConvidadoByEvento(Evento evento);

}
