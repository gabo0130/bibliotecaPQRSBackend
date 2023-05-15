package com.pqrs.biblioteca.entity;

import java.util.List;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "edad")
    private long edad;
    
    @Column(name = "identificacion")
    private String identificacion;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @OneToMany(mappedBy = "personaSolicitante", cascade = CascadeType.ALL)
    private List<Solicitud> personaSolicitante;

}
