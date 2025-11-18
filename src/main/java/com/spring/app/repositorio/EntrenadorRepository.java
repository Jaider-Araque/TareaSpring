package com.spring.app.repositorio;

import com.spring.app.entidades.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    // Por ahora vacío - JpaRepository nos da todos los métodos CRUD
}