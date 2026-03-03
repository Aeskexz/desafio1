package com.udb.desafio1.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data           // Lombok: genera getters, setters, toString, equals automáticamente
@Entity         // Le dice a JPA que esta clase es una tabla en la Bd
@Table(name = "productos")  // El nombre exacto de la tabla en H2
public class Producto {

    @Id                                              // Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremento
    private Long id;

    private String nombre;
    private Double precio;
}