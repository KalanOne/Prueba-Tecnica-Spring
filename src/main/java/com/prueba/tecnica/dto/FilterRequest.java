package com.prueba.tecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// Clase interna para manejar las solicitudes de filtrado
@Data
@AllArgsConstructor
public class FilterRequest {
    private String nombre;
    private String categoria;
    private Boolean disponible;
    private Double precioMaximo;
}