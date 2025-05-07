package org.william.modelo;

public class Mensaje<T> {
    private String mensaje;
    private T data;

    public Mensaje(String mensaje, T data) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
