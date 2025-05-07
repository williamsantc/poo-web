package org.william.controller;

import io.javalin.Javalin;
import org.william.exception.BadParameterException;
import org.william.exception.NotFoundException;
import org.william.modelo.Mensaje;

public class ExceptionController {

    public void iniciarControl(Javalin app) {
        app.exception(NotFoundException.class, (e, ctx) -> {
            Mensaje mensaje = new Mensaje(e.getMessage(), null);
            ctx.status(404);
            ctx.json(mensaje);
        });

        app.exception(BadParameterException.class, (e, ctx) -> {
            Mensaje mensaje = new Mensaje(e.getMessage(), null);
            ctx.status(400);
            ctx.json(mensaje);
        });
    }
}
