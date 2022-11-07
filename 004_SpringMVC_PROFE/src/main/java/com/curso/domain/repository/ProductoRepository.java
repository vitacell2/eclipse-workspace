
package com.curso.domain.repository;

import com.curso.domain.Producto;
import java.util.List;

public interface ProductoRepository {
    List <Producto> getAllProductos();
    Producto getProductoById(String idProducto);
    void create(Producto producto);
    void update(Producto producto);
    List <Producto> getProductosPorCategoria(String categoria);
    void delete(String idProducto);
}
