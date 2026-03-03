package com.udb.desafio1;

import com.udb.desafio1.entity.Producto;
import com.udb.desafio1.service.ProductoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Desafio1ApplicationTests {

	@Autowired
	ProductoService productoService;

	@Test
	@Order(1)
	void insertar_registros_test() {
		for (int i = 1; i <= 100; i++) {
			Producto p = new Producto();
			p.setNombre("Producto " + i);
			p.setPrecio(i * 10.0);
			productoService.insertar(p);
		}
		assertEquals(100, productoService.contarTodos());
	}

	@Test
	@Order(2)
	void leer_registros_test() {
		assertEquals(25, productoService.obtenerPrimeros25().size());
	}

	@Test
	@Order(3)
	void modificar_registro_test() {
		productoService.modificar(50L, "Modificado", 999.9);
		Producto p = productoService.obtenerPorId(50L);
		assertEquals("Modificado", p.getNombre());
	}

	@Test
	@Order(4)
	void borrar_registro_test() {
		productoService.borrar(75L);
		assertNull(productoService.obtenerPorId(75L));
	}
}