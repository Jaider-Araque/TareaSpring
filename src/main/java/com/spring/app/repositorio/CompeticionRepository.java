package com.spring.app.repositorio;

import com.spring.app.entidades.Competicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompeticionRepository extends JpaRepository<Competicion, Long> {
    // Método personalizado para buscar competiciones por nombre
    List<Competicion> findByNombreContaining(String nombre);
}