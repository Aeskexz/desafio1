package com.udb.desafio1.service;

import com.udb.desafio1.entity.Producto;
import com.udb.desafio1.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service   // Componente de lógica de negocio, manejado por el contenedor de Spring
public class ProductoService {

    @Autowired   // Inyección de Dependencia (DI) — Spring inyecta el repositorio automáticamente
    private ProductoRepository productoRepository;
    // Insertar un producto
    public Producto insertar(Producto producto) {
        return productoRepository.save(producto);
    }

    // Total de registros
    public long contarTodos() {
        return productoRepository.count();
    }

    // Primeros 25 registros
    public List<Producto> obtenerPrimeros25() {
        return productoRepository.findFirst25By();
    }

    // Obtener por ID
    public Producto obtenerPorId(Long id) {
        Optional<Producto> resultado = productoRepository.findById(id);
        return resultado.orElse(null);
    }

    // Modificar por ID
    public Producto modificar(Long id, String nuevoNombre, Double nuevoPrecio) {
        Producto producto = obtenerPorId(id);
        producto.setNombre(nuevoNombre);
        producto.setPrecio(nuevoPrecio);
        return productoRepository.save(producto);
    }

    // Borrar por ID
    public void borrar(Long id) {
        productoRepository.deleteById(id);
    }
}