package com.pqrs.biblioteca.entity;

import java.util.Date;

import javax.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "solicitud")
public class Solicitud {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
    
        @Column(name = "descripcion")
        private String descripcion;

        @Column(name = "estado")
        private String estado;

        @Column(name = "fecha")
        private Date fecha;

        @Column(name = "correoAdicionado")
        private String correoAdicionado;

        @Column(name = "telefonoAdicionado")
        private String telefonoAdicionado;

        @Column(name = "rutaArchivos")
        private String rutaArchivos;
    
        @ManyToOne
        @JoinColumn(name = "tipoSolicitud_id")
        private TipoSolicitud tipoSolicitud;
    
        @ManyToOne
        @JoinColumn(name = "persona_solicitante_id")
        private Persona personaSolicitante;
        
        @ManyToOne
        @JoinColumn(name = "usuario_aprobador_id")
        private Usuario usuarioAprobador;
        
        @OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL)
        private Respuesta respuesta;
}
