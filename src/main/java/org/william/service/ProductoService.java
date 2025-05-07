package org.william.service;

import org.william.exception.BadParameterException;
import org.william.exception.NotFoundException;
import org.william.modelo.Producto;
import org.william.repository.ProductosRepository;

import java.util.List;

public class ProductoService {

    private final ProductosRepository productosRepository;

    public ProductoService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    private void validarProducto(Producto producto) throws BadParameterException {
        if (producto == null) {
            throw new BadParameterException("Producto no puede estar vacio");
        }

        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            throw new BadParameterException("El nombre del producto no puede estar vacio");
        }
        if (producto.getPrecio() <= 0) {
            throw new BadParameterException("El precio del producto no puede ser menor o igual a cero");
        }

        if (producto.getCantidad() < 0) {
            throw new BadParameterException("La cantidad del producto no puede ser menor a cero");
        }

        if (producto.getCategoria() == null || producto.getCategoria().isEmpty()) {
            throw new BadParameterException("La categoria del producto no puede estar vacia");
        }
    }

    public void guardarProducto(Producto producto) {
        this.validarProducto(producto);
        this.productosRepository.agregarProducto(producto);
    }

    public void eliminarProducto(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el producto");
        }
        Producto producto = this.productosRepository.eliminarProducto(Integer.parseInt(id));
        if (producto == null) {
            throw new NotFoundException("No existe el producto");
        }
    }

    public void actualizarProducto(String id, Producto productoActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el producto");
        }
        this.validarProducto(productoActualizar);
        Producto producto = this.productosRepository.actualizarProducto(Integer.parseInt(id), productoActualizar);
        if (producto == null) {
            throw new NotFoundException("No existe el producto");
        }
    }

    public Producto obtenerProducto(String id) {
        if (id == null) {
            throw new NotFoundException("No existe el producto");
        }

        return this.productosRepository.obtenerProducto(Integer.parseInt(id));
    }

    public List<Producto> obtenerProductos() {
        return this.productosRepository.obtenerProductos();
    }
}
