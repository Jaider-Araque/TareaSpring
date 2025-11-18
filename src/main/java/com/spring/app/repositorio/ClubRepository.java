package com.spring.app.repositorio;

import com.spring.app.entidades.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    // Método personalizado para buscar clubes por nombre
    List<Club> findByNombreContaining(String nombre);
}