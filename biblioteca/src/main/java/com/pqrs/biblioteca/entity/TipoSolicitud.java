package com.pqrs.biblioteca.entity;


import java.util.List;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tipoSolicitud")
public class TipoSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tipoSolicitud")
    private String tipoSolicitud;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tipoSolicitud", cascade = CascadeType.ALL)
    private List<Solicitud> Solicitudes;

    
}
