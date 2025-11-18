package com.spring.app.controller;

import com.spring.app.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class PruebaController {

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

    // Página de inicio
    @GetMapping("/")
    public String paginaInicio(Model model) {
        model.addAttribute("tecnologias", Arrays.asList(
            "Spring Boot 3.5.7", "Spring Data JPA", "H2 Database", 
            "Thymeleaf", "Bootstrap 5", "Java 21"
        ));
        return "inicio";
    }

    // Vista de clubes
    @GetMapping("/clubes/vista")
    public String listarClubesVista(Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        return "clubes";
    }

    // === NUEVOS MÉTODOS PARA MOSTRAR TODAS LAS TABLAS ===

    // Mostrar todos los entrenadores
    @GetMapping("/entrenadores")
    public String listarEntrenadores(Model model) {
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        return "entrenadores";
    }

    // Mostrar todos los jugadores
    @GetMapping("/jugadores")
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "jugadores";
    }

    // Mostrar todas las asociaciones
    @GetMapping("/asociaciones")
    public String listarAsociaciones(Model model) {
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        return "asociaciones";
    }

    // Mostrar todas las competiciones
    @GetMapping("/competiciones")
    public String listarCompeticiones(Model model) {
        model.addAttribute("competiciones", competicionRepository.findAll());
        return "competiciones";
    }

    // Mostrar TODAS las tablas en una página
    @GetMapping("/todas-tablas")
    public String mostrarTodasLasTablas(Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
        return "todas-tablas";
    }
}