package com.prueba.tecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpRequest {
    private String nombre;
    private String apellido;
    private String username;
    private String email;
    private String password;
}