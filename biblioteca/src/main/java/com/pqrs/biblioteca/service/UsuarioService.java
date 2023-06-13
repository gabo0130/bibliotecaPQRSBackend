package com.pqrs.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pqrs.biblioteca.entity.Usuario;
import com.pqrs.biblioteca.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodoslosUsuarios() throws Exception {
        try {
            return usuarioRepository.findAll();
        } catch(Exception ex) {
            throw new Exception("Error al obtener los tipos", ex);
        }
    }

}
