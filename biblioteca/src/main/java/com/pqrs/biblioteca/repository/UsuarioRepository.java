package com.pqrs.biblioteca.repository;

import com.pqrs.biblioteca.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}