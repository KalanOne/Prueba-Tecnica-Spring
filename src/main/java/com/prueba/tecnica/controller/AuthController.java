package com.prueba.tecnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.dto.ApiResponse;
import com.prueba.tecnica.dto.JwtAuthenticationResponse;
import com.prueba.tecnica.dto.LoginRequest;
import com.prueba.tecnica.dto.SignUpRequest;
import com.prueba.tecnica.model.Usuario;
import com.prueba.tecnica.security.JwtTokenProvider;
import com.prueba.tecnica.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final JwtTokenProvider tokenProvider;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                        UsuarioService usuarioService,
                        JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignUpRequest signUpRequest) {
        Usuario usuario = new Usuario();
        usuario.setNombre(signUpRequest.getNombre());
        usuario.setApellido(signUpRequest.getApellido());
        usuario.setUsername(signUpRequest.getUsername());
        usuario.setEmail(signUpRequest.getEmail());
        usuario.setPassword(signUpRequest.getPassword());

        usuarioService.registrarUsuario(usuario, "ROLE_USER");

        return ResponseEntity.ok(new ApiResponse(true, "Usuario registrado exitosamente"));
    }
}