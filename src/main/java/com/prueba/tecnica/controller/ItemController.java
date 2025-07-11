package com.prueba.tecnica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.dto.FilterRequest;
import com.prueba.tecnica.model.Item;
import com.prueba.tecnica.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Item>> filterItems(@RequestBody FilterRequest request) {
        if (request.getNombre() != null) {
            return ResponseEntity.ok(itemService.getItemsByNombre(request.getNombre()));
        }
        if (request.getCategoria() != null) {
            return ResponseEntity.ok(itemService.getItemsByCategoria(request.getCategoria()));
        }
        if (request.getDisponible() != null) {
            return ResponseEntity.ok(itemService.getItemsByDisponibilidad(request.getDisponible()));
        }
        if (request.getPrecioMaximo() != null) {
            return ResponseEntity.ok(itemService.getItemsByPrecioMaximo(request.getPrecioMaximo()));
        }

        // Si no hay filtros, devolver todos los items
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item existingItem = itemService.getItemById(id);
        if (existingItem != null) {
            item.setId(id);
            return ResponseEntity.ok(itemService.saveItem(item));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        Item existingItem = itemService.getItemById(id);
        if (existingItem != null) {
            itemService.deleteItem(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}