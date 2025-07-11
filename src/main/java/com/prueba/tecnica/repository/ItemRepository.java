package com.prueba.tecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
    List<Item> findByNombreContainingIgnoreCase(String nombre);
    
    List<Item> findByCategoria(String categoria);
    
    List<Item> findByDisponible(Boolean disponible);
    
    List<Item> findByPrecioLessThanEqual(Double precio);
}