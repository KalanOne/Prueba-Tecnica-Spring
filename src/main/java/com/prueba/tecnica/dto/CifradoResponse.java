package com.prueba.tecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// Clase interna para manejar las respuestas de Cifrado
@Data
@AllArgsConstructor
public class CifradoResponse {
    private String resultado;
}