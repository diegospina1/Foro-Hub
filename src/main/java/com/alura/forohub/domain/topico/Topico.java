package com.alura.forohub.domain.topico;

import com.alura.forohub.domain.curso.Curso;
import com.alura.forohub.domain.respuesta.Respuesta;
import com.alura.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;


    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario usuario, Curso curso) {
        this.titulo = datosRegistroTopico.titulo();
        this.descripcion = datosRegistroTopico.descripcion();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = Estado.ACTIVO;
        this.autor = usuario;
        this.curso = curso;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.descripcion() != null){
            this.descripcion = datosActualizarTopico.descripcion();
        }
        if(datosActualizarTopico.estado() != null){
            this.estado = datosActualizarTopico.estado();
        }
    }

    public void desactivarTopico(){
        this.estado = Estado.DESACTIVADO;
    }
}
