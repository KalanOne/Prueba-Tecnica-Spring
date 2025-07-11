package com.prueba.tecnica.service;

import java.util.List;

import com.prueba.tecnica.model.Item;

public interface ItemService {

    List<Item> getAllItems();

    List<Item> getItemsByNombre(String nombre);

    List<Item> getItemsByCategoria(String categoria);

    List<Item> getItemsByDisponibilidad(Boolean disponible);

    List<Item> getItemsByPrecioMaximo(Double precio);

    Item saveItem(Item item);

    void deleteItem(Long id);

    Item getItemById(Long id);
}