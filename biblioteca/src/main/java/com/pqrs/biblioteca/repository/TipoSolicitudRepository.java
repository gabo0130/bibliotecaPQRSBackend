package com.pqrs.biblioteca.repository;

import com.pqrs.biblioteca.entity.TipoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitud, Long> {
}