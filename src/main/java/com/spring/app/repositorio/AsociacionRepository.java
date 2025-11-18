package com.spring.app.repositorio;

import com.spring.app.entidades.Asociacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsociacionRepository extends JpaRepository<Asociacion, Long> {
    // Por ahora vacío - JpaRepository nos da todos los métodos CRUD
}