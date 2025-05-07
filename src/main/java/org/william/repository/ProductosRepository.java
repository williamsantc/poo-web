package org.william.repository;

import org.william.modelo.Producto;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductosRepository {
    private final ArrayList<Producto> productos = new ArrayList<Producto>();
    private final AtomicInteger autoId = new AtomicInteger(1);

    public void agregarProducto(Producto producto) {
        producto.setId(this.autoId.getAndIncrement());
        this.productos.add(producto);
    }

    public Producto eliminarProducto(int id) {
        Producto producto = null;
        for (int i = 0; i < this.productos.size(); i++) {
            if (this.productos.get(i).getId() == id) {
                producto = this.productos.remove(i);
                break;
            }
        }
        return producto;
    }

    public Producto actualizarProducto(int id, Producto productoActualizado) {
        Producto producto = null;
        for (int i = 0; i < this.productos.size(); i++) {
            if (this.productos.get(i).getId() == id) {
                this.productos.set(i, productoActualizado);
                producto = productoActualizado;
                break;
            }
        }
        return producto;
    }

    public Producto obtenerProducto(int id) {
        for (Producto producto : this.productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public ArrayList<Producto> obtenerProductos() {
        return this.productos;
    }
}
