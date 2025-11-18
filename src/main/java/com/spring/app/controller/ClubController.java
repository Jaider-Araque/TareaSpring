package com.spring.app.controller;

import com.spring.app.entidades.Club;
import com.spring.app.repositorio.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clubes")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    // GET - Obtener todos los clubes
    @GetMapping
    public List<Club> obtenerTodosLosClubes() {
        return clubRepository.findAll();
    }

    // GET - Obtener un club por ID
    @GetMapping("/{id}")
    public ResponseEntity<Club> obtenerClubPorId(@PathVariable Long id) {
        Optional<Club> club = clubRepository.findById(id);
        if (club.isPresent()) {
            return ResponseEntity.ok(club.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST - Crear un nuevo club
    @PostMapping
    public Club crearClub(@RequestBody Club club) {
        return clubRepository.save(club);
    }

    // PUT - Actualizar un club existente
    @PutMapping("/{id}")
    public ResponseEntity<Club> actualizarClub(@PathVariable Long id, @RequestBody Club clubActualizado) {
        Optional<Club> clubExistente = clubRepository.findById(id);
        if (clubExistente.isPresent()) {
            Club club = clubExistente.get();
            club.setNombre(clubActualizado.getNombre());
            // Aquí luego agregaremos más campos a actualizar
            return ResponseEntity.ok(clubRepository.save(club));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Eliminar un club
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarClub(@PathVariable Long id) {
        Optional<Club> club = clubRepository.findById(id);
        if (club.isPresent()) {
            clubRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}