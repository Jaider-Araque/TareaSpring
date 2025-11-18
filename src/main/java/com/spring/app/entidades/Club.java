package com.spring.app.entidades;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clubes")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    // RELACIÓN UNO A UNO con Entrenador (LAZY como pidió tu profesor)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenador_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Entrenador entrenador;

    // RELACIÓN MUCHOS A UNO con Asociacion
    @ManyToOne
    @JoinColumn(name = "asociacion_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Asociacion asociacion;

    // RELACIÓN UNO A MUCHOS con Jugadores (EAGER como pidió tu profesor)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "club_id")
    private List<Jugador> jugadores = new ArrayList<>();

    // RELACIÓN MUCHOS A MUCHOS con Competiciones
    @ManyToMany
    @JoinTable(
        name = "club_competicion",
        joinColumns = @JoinColumn(name = "club_id"),
        inverseJoinColumns = @JoinColumn(name = "competicion_id")
    )
    private List<Competicion> competiciones = new ArrayList<>();

    // Constructor vacío
    public Club() {}

    // Constructor con parámetros básicos
    public Club(String nombre) {
        this.nombre = nombre;
    }

    // Constructor completo
    public Club(String nombre, Entrenador entrenador, Asociacion asociacion) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.asociacion = asociacion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Asociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(Asociacion asociacion) {
        this.asociacion = asociacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Competicion> getCompeticiones() {
        return competiciones;
    }

    public void setCompeticiones(List<Competicion> competiciones) {
        this.competiciones = competiciones;
    }
}