package com.prueba.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.dto.CifradoRequest;
import com.prueba.tecnica.dto.CifradoResponse;
import com.prueba.tecnica.service.CifradoService;

@RestController
@RequestMapping("/api/cifrado")
public class CifradoController {

    @Autowired
    private CifradoService cifradoService;

    @PostMapping("/cifrar")
    public ResponseEntity<CifradoResponse> cifrarTexto(@RequestBody CifradoRequest request) {
        String textoCifrado = cifradoService.cifrar(request.getTexto());
        return ResponseEntity.ok(new CifradoResponse(textoCifrado));
    }

    @PostMapping("/descifrar")
    public ResponseEntity<CifradoResponse> descifrarTexto(@RequestBody CifradoRequest request) {
        String textoDescifrado = cifradoService.descifrar(request.getTexto());
        return ResponseEntity.ok(new CifradoResponse(textoDescifrado));
    }

}