package com.pqrs.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqrs.biblioteca.entity.TipoSolicitud;
import com.pqrs.biblioteca.repository.TipoSolicitudRepository;

@Service
public class TipoSolicitudService {
    @Autowired
    private TipoSolicitudRepository tipoSolicitudRepository;

    public List<TipoSolicitud> obtenerTodosLosTipos() throws Exception {
        try {
            return tipoSolicitudRepository.findAll();
        } catch(Exception ex) {
            throw new Exception("Error al obtener los tipos", ex);
        }
    }

}
