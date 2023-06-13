package com.pqrs.biblioteca.repository;

import com.pqrs.biblioteca.entity.Solicitud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    @Query("SELECT s FROM Solicitud s WHERE s.usuarioAprobador.id = :idUsuario")
List<Solicitud> obtenerSolicitudPorIdUsuario(@Param("idUsuario") Long idUsuario);

}