package com.curso.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;

@RestController
public class ProductosRESTController {

	@Autowired
	@Qualifier("jpaProductoRepository")
	private ProductoRepository repositorio;

	// todos
	@GetMapping("/rest/productos")
	public List<Producto> all() {
		return repositorio.getAllProductos();
	}

	// por id
	@GetMapping("/rest/productos/{id}")
	public Producto get(@PathVariable String id) {
		return repositorio.getProductoById(id);
	}

	// crear
	@PostMapping("/rest/productos")
	public Producto crear(@RequestBody Producto nuevoProducto) {

		repositorio.create(nuevoProducto);
		return nuevoProducto;
	}

	// modificar
	@PutMapping("/rest/productos/{id}")
	public Producto modificar(@RequestBody Producto producto, @PathVariable String id) {
		// falta validar que existe
		repositorio.update(producto);
		return producto;
	}

	// borrar
	@DeleteMapping("/rest/productos/{id}")
	public void borrar( @PathVariable String id) {
		repositorio.delete(id);
	}

}
