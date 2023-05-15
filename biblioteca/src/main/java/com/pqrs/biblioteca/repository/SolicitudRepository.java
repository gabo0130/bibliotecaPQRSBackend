package com.pqrs.biblioteca.repository;

import com.pqrs.biblioteca.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}