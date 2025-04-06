package org.william.modelo;

public class Mensaje {
    private String mensaje;
    private String data;

    public Mensaje(String mensaje, String data) {
        this.mensaje = mensaje;
        this.data = data;
    }

    public Mensaje() {}

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
