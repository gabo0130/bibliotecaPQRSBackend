package com.pqrs.biblioteca.repository;

import com.pqrs.biblioteca.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}