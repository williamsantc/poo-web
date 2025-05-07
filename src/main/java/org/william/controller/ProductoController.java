package org.william.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.william.modelo.Mensaje;
import org.william.modelo.Producto;
import org.william.service.ProductoService;

public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/productos", this::guardarProducto);
        app.get("/productos/{id}", this::obtenerProducto);
        app.delete("/productos/{id}", this::eliminarProducto);
        app.put("/productos/{id}", this::actualizarProducto);
        app.get("/productos", this::listarProductos);
    }

    public void guardarProducto(Context ctx) {
        ctx.contentType("application/json");
        Producto producto = ctx.bodyAsClass(Producto.class);

        productoService.guardarProducto(producto);

        Mensaje<Producto> mensaje = new Mensaje<Producto>("Producto agregado", producto);

        ctx.status(201);
        ctx.json(mensaje);
    }

    public void obtenerProducto(Context ctx) {
        String id = ctx.pathParam("id");
        Producto producto = productoService.obtenerProducto(id);
        ctx.json(producto);
    }

    public void eliminarProducto(Context ctx) {
        String id = ctx.pathParam("id");
        productoService.eliminarProducto(id);
        Mensaje<String> mensaje = new Mensaje<>("Producto eliminado", id);
        ctx.status(200);
        ctx.json(mensaje);

    }

    public void actualizarProducto(Context ctx) {
        String id = ctx.pathParam("id");
        Producto productoActualizado = ctx.bodyAsClass(Producto.class);

        productoService.actualizarProducto(id, productoActualizado);

        Mensaje<Producto> mensaje = new Mensaje<>("Producto actualizado", productoActualizado);
        ctx.status(200);
        ctx.json(mensaje);
    }

    public void listarProductos(Context ctx) {
        ctx.json(productoService.obtenerProductos());
    }
}
