package com.pqrs.biblioteca.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pqrs.biblioteca.entity.TipoSolicitud;
import com.pqrs.biblioteca.service.TipoSolicitudService;

@RestController
@RequestMapping("/TipoSolicitud")
public class TipoSolicitudController {
    
    @Autowired
    private TipoSolicitudService tipoSolicitudService;

    @GetMapping("/")
    public List<TipoSolicitud> obtenerTodasLosTipos() throws Exception {
        return tipoSolicitudService.obtenerTodosLosTipos();
    }
    
    

}