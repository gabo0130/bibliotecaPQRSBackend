package com.pqrs.biblioteca.repository;

import com.pqrs.biblioteca.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}