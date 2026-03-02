package com.udb.desafio1;

import com.udb.desafio1.entity.Producto;
import com.udb.desafio1.repository.ProductoRepository;
import com.udb.desafio1.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Desafio1ApplicationTests {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private ProductoRepository productoRepository;

	@BeforeEach
	void limpiar() {
		productoRepository.deleteAll();
		for (int i = 1; i <= 100; i++) {
			Producto p = new Producto();
			p.setNombre("Producto " + i);
			p.setPrecio(i * 10.0);
			productoService.insertar(p);
		}
	}

	@Test
	void insertar_registros_test() {
		long total = productoService.contarTodos();
		assertEquals(100, total);
	}

	@Test
	void leer_registros_test() {
		List<Producto> primeros25 = productoService.obtenerPrimeros25();
		assertEquals(25, primeros25.size());
	}

	@Test
	void modificar_registro_test() {
		Producto primero = productoRepository.findAll().get(49);
		productoService.modificar(primero.getId(), "Producto Modificado", 999.99);
		Producto modificado = productoService.obtenerPorId(primero.getId());
		assertEquals("Producto Modificado", modificado.getNombre());
	}

	@Test
	void borrar_registro_test() {
		Producto aEliminar = productoRepository.findAll().get(74);
		Long idEliminar = aEliminar.getId();
		productoService.borrar(idEliminar);
		Producto borrado = productoService.obtenerPorId(idEliminar);
		assertNull(borrado);
	}
}