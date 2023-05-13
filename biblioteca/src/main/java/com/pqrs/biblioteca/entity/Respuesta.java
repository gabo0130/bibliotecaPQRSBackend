package com.pqrs.biblioteca.entity;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "respuesta")
public class Respuesta {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        
        @Column(name = "descripcion")
        private String descripcion;

        @Column(name = "fecha")
        private String fecha;
        
        @OneToOne
        @JoinColumn(name = "solicitud_id")
        private Solicitud solicitud;
        
        @ManyToOne
        @JoinColumn(name = "usuario_aprobador_id")
        private Usuario usuarioAprobador;

}
