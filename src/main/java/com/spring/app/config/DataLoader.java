package com.spring.app.config;

import com.spring.app.entidades.*;
import com.spring.app.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Autowired
    private AsociacionRepository asociacionRepository;

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private CompeticionRepository competicionRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear datos de prueba automáticamente
        crearDatosDePrueba();
    }

    private void crearDatosDePrueba() {
        // 1. Crear Asociaciones
        Asociacion fcf = new Asociacion("Federación Colombiana de Fútbol", "FCF", "Colombia", "Presidente FCF");
        Asociacion conmebol = new Asociacion("CONMEBOL", "CSF", "Sudamérica", "Presidente CONMEBOL");
        asociacionRepository.saveAll(Arrays.asList(fcf, conmebol));

        // 2. Crear Entrenadores
        Entrenador entrenador1 = new Entrenador("Juan", "Pérez", 45, "Colombiano");
        Entrenador entrenador2 = new Entrenador("Carlos", "Gómez", 50, "Argentino");
        entrenadorRepository.saveAll(Arrays.asList(entrenador1, entrenador2));

        // 3. Crear Competiciones
        Competicion liga = new Competicion("Liga BetPlay", 100000000, LocalDate.of(2024, 1, 15), LocalDate.of(2024, 6, 15));
        Competicion copa = new Competicion("Copa Colombia", 50000000, LocalDate.of(2024, 2, 1), LocalDate.of(2024, 11, 30));
        competicionRepository.saveAll(Arrays.asList(liga, copa));

        // 4. Crear Jugadores
        Jugador jugador1 = new Jugador("Luis", "Díaz", 7, "Delantero");
        Jugador jugador2 = new Jugador("James", "Rodríguez", 10, "Mediocampista");
        Jugador jugador3 = new Jugador("David", "Ospina", 1, "Portero");
        jugadorRepository.saveAll(Arrays.asList(jugador1, jugador2, jugador3));

        // 5. Crear Clubes con relaciones
        Club millonarios = new Club("Millonarios FC");
        millonarios.setEntrenador(entrenador1);
        millonarios.setAsociacion(fcf);
        millonarios.setJugadores(Arrays.asList(jugador1, jugador2));
        millonarios.setCompeticiones(Arrays.asList(liga, copa));

        Club nacional = new Club("Atlético Nacional");
        nacional.setEntrenador(entrenador2);
        nacional.setAsociacion(fcf);
        nacional.setJugadores(Arrays.asList(jugador3));
        nacional.setCompeticiones(Arrays.asList(liga));

        clubRepository.saveAll(Arrays.asList(millonarios, nacional));

        System.out.println("✅ Datos de prueba creados automáticamente!");
    }
}