package com.prueba.tecnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.model.Item;
import com.prueba.tecnica.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    public List<Item> getItemsByNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return getAllItems();
        }
        return itemRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    public List<Item> getItemsByCategoria(String categoria) {
        return itemRepository.findByCategoria(categoria);
    }
    
    public List<Item> getItemsByDisponibilidad(Boolean disponible) {
        return itemRepository.findByDisponible(disponible);
    }
    
    public List<Item> getItemsByPrecioMaximo(Double precio) {
        return itemRepository.findByPrecioLessThanEqual(precio);
    }
    
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
    
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
    
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}