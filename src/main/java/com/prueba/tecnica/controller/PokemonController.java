package com.prueba.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.service.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;
    
    @GetMapping("/ditto")
    public ResponseEntity<Object> getDitto() {
        return ResponseEntity.ok(pokemonService.getDitto());
    }
    
    @GetMapping("/{name}")
    public ResponseEntity<Object> getPokemonByName(@PathVariable String name) {
        return ResponseEntity.ok(pokemonService.getPokemonByName(name));
    }
}