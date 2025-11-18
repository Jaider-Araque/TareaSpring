package com.spring.app.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "asociaciones")
public class Asociacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String siglas;  // ← CAMPO NUEVO
    private String pais;
    private String presidente;

    // Constructor vacío
    public Asociacion() {}

    // Constructor con parámetros (actualizado)
    public Asociacion(String nombre, String siglas, String pais, String presidente) {
        this.nombre = nombre;
        this.siglas = siglas;  // ← AGREGADO
        this.pais = pais;
        this.presidente = presidente;
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

    public String getSiglas() {  // ← GETTER NUEVO
        return siglas;
    }

    public void setSiglas(String siglas) {  // ← SETTER NUEVO
        this.siglas = siglas;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }
}