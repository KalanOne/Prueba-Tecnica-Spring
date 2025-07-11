package com.prueba.tecnica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByUsername(String username);
    
    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);
}