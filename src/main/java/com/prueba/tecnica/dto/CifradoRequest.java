package com.prueba.tecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Clase interna para manejar las solicitudes de Cifrado
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CifradoRequest {
    private String texto;
}