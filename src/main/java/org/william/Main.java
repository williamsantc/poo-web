package org.william;

import io.javalin.Javalin;
import org.william.controller.ExceptionController;
import org.william.controller.HealthController;
import org.william.controller.ProductoController;
import org.william.repository.ProductosRepository;
import org.william.service.ProductoService;

public class Main {
    public static void main(String[] args) {
        ProductosRepository productosRepository = new ProductosRepository();
        ProductoService productoService = new ProductoService(productosRepository);
        ProductoController productoController = new ProductoController(productoService);
        ExceptionController exceptionController = new ExceptionController();
        HealthController healthController = new HealthController();

        var app = Javalin.create();

        exceptionController.iniciarControl(app);

        healthController.configurarRutas(app);
        productoController.configurarRutas(app);

        app.before(ctx -> ctx.header("Content-Type", "application/json"));

        app.start(4567);
    }
}
