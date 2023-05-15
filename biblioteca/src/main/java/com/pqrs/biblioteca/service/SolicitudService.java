package com.pqrs.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqrs.biblioteca.entity.Solicitud;
import com.pqrs.biblioteca.repository.SolicitudRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public List<Solicitud> obtenerTodasLasSolicitudes() throws Exception {
        try {
            return solicitudRepository.findAll();
        } catch (Exception ex) {
            throw new Exception("Error al obtener las Solicitudes", ex);
        }
    }

    public Solicitud obtenerSolicitudPorId(long id) {
        return solicitudRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Solicitud no encontrada"));
    }

    public Solicitud crearSolicitud(Solicitud Solicitud) throws Exception {
        try {
            return solicitudRepository.save(Solicitud);
        } catch (Exception ex) {
            throw new Exception("Error al crear la Solicitud", ex);
        }
    }

    public Solicitud actualizarSolicitud(long id, Solicitud solicitudActualizada, String parametroAct) throws Exception {
        try {
            Solicitud solicitudEncontrada = solicitudRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Solicitud no encontrada"));
            
            switch (parametroAct) {
                case "estado":
                    solicitudEncontrada.setEstado(solicitudActualizada.getEstado());
                    break;
                case "ruta":
                    solicitudEncontrada.setRutaArchivos(solicitudActualizada.getRutaArchivos());
                    break;
                case "usuarioAprobador":
                    solicitudEncontrada.setUsuarioAprobador(solicitudActualizada.getUsuarioAprobador());
                    break;
                case "descripcion":
                    solicitudEncontrada.setDescripcion(solicitudActualizada.getDescripcion());
                    break;
                default:
                    throw new IllegalArgumentException("El parámetro especificado no es válido");
            }
            
            Solicitud solicitudGuardada = solicitudRepository.save(solicitudEncontrada);
            return solicitudGuardada;
        } catch(NoSuchElementException ex) {
            throw new NoSuchElementException("La solicitud especificada no fue encontrada");
        } catch(IllegalArgumentException ex) {
            throw new IllegalArgumentException("El parámetro especificado no es válido");
        } catch(Exception ex) {
            throw new Exception("Se ha producido un error al actualizar la solicitud", ex);
        }
    }
}