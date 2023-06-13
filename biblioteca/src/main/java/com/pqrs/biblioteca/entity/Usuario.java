package com.pqrs.biblioteca.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "usuario")
@PrimaryKeyJoinColumn(name = "id")
public class Usuario extends Persona {

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contrasena")
    private String contrasena;

    
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioAprobador", cascade = CascadeType.ALL)
    private List<Solicitud> usuarioAprobador;
    
}
