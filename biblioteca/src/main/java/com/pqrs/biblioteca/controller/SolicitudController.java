package com.pqrs.biblioteca.controller;

import com.pqrs.biblioteca.entity.Persona;
import com.pqrs.biblioteca.entity.Solicitud;
import com.pqrs.biblioteca.service.PersonaService;
import com.pqrs.biblioteca.service.SolicitudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/solitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public List<Solicitud> obtenerTodasLasSolicitudes() throws Exception {
        return solicitudService.obtenerTodasLasSolicitudes();
    }

    @GetMapping("/{id}")
    public Solicitud obtenerSolicitudPorId(@PathVariable long id) throws Exception {
        return solicitudService.obtenerSolicitudPorId(id);
    }
    @PostMapping("/")
    public ResponseEntity<?> crearSolicitud(@RequestBody Solicitud solicitud)
            throws Exception {
        return new ResponseEntity<>(solicitudService.crearSolicitud(solicitud), HttpStatus.CREATED);
    }
 
    @PostMapping("/persona")
    public ResponseEntity<?> crearPersonaSolicitud(@RequestBody Persona persona, @RequestBody Solicitud solicitud)
            throws Exception {
        Persona personaCreada = personaService.crearPersona(persona);
        solicitud.setPersonaSolicitante(personaCreada);
        return new ResponseEntity<>(solicitudService.crearSolicitud(solicitud), HttpStatus.CREATED);
    }

    @PostMapping("persona/{id_persona}")
    public ResponseEntity<?> crearSolicitudPersonaRegistrada(@PathVariable long id, @RequestBody Solicitud solicitud) throws Exception {
        Persona persona = new Persona();
        persona.setId(id);
        solicitud.setPersonaSolicitante(persona);
        return new ResponseEntity<>(solicitudService.crearSolicitud(solicitud), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarSolicitud(@PathVariable long id, @RequestBody Solicitud solicitud)
            throws Exception {
        Solicitud solicitudActualizada = solicitudService.actualizarSolicitud(id, solicitud,"descripcion");
        return new ResponseEntity<>(solicitudActualizada, HttpStatus.OK);
    }

    @PostMapping("/{id}/archivos")
    public ResponseEntity<String> cargarArchivos(@PathVariable("id") Long idSolicitud,
            @RequestParam("archivos") MultipartFile[] archivos) throws Exception {
        
        Solicitud solicitud = solicitudService.obtenerSolicitudPorId(idSolicitud);
        String rutaCarpeta = "src/main/resources/data/" + "solicitud_" + solicitud.getId();
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            if (!carpeta.mkdirs()) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo crear la carpeta");
            }
        }
        solicitud.setRutaArchivos(rutaCarpeta);
        solicitudService.actualizarSolicitud(idSolicitud,solicitud,"ruta");
        for (MultipartFile archivo : archivos) {
            String nombreArchivo = archivo.getOriginalFilename();
            if (!archivo.isEmpty()){
                String rutaArchivo = rutaCarpeta + "/" + nombreArchivo;
                try {
                    Files.copy(archivo.getInputStream(), Paths.get(rutaArchivo), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo guardar el archivo");
                }
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El archivo está vacío");
            }
        }

        return ResponseEntity.ok("Archivos cargados correctamente");
    }
}