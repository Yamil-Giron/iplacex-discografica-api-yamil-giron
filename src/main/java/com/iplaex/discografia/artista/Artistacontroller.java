package com.iplaex.discografia.artista;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class Artistacontroller {

    @Autowired
    private IArtistaRepository repo;

    @PostMapping(value = "/artista", consumes = "application/json", produces = "application/json")
    public Artista HandleInsertArtistaRequest(@RequestBody Artista artista) {
        return repo.save(artista);
    }

    @GetMapping(value = "/artistas", produces = "application/json")
    public List<Artista> HandleGetAristasRequest() {
        return repo.findAll();
    }

    @GetMapping(value = "/artista/{id}", produces = "application/json")
    public Optional<Artista> HandleGetArtistaRequest(@PathVariable String id) {
        return repo.findById(id);
    }

    @PutMapping(value = "/artista/{id}", consumes = "application/json", produces = "application/json")
    public Artista HandleUpdateArtistaRequest(@PathVariable String id, @RequestBody Artista artista) {
        artista.setId(id);
        return repo.save(artista);
    }

    @DeleteMapping(value = "/artista/{id}", produces = "application/json")
    public void HandleDeleteArtistaRequest(@PathVariable String id) {
        repo.deleteById(id);
    }
}
