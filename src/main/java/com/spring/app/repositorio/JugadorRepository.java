package com.spring.app.repositorio;

import com.spring.app.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    // Método personalizado para buscar jugadores por posición
    List<Jugador> findByPosicion(String posicion);
}