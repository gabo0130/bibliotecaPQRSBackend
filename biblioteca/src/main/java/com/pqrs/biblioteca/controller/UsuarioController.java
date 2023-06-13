package com.pqrs.biblioteca.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pqrs.biblioteca.entity.Usuario;
import com.pqrs.biblioteca.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<Usuario> obtenerTodoslosUsuarios() throws Exception {
        return usuarioService.obtenerTodoslosUsuarios();
    }
    
    

}