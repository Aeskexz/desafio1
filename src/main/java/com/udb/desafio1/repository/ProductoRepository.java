package com.udb.desafio1.repository;

import com.udb.desafio1.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository   // Marca este componente como repositorio (parte del IoC de Spring)
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findFirst25By();  // Spring genera el SQL automáticamente
}