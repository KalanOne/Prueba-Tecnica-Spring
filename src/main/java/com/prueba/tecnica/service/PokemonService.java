package com.prueba.tecnica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    private static final String POKEMON_API_URL = "https://pokeapi.co/api/v2/pokemon/";
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Object getPokemonByName(String name) {
        return restTemplate.getForObject(POKEMON_API_URL + name, Object.class);
    }
    
    public Object getDitto() {
        return restTemplate.getForObject(POKEMON_API_URL + "ditto", Object.class);
    }
}