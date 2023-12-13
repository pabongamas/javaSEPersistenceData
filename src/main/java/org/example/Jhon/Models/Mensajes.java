package org.example.Jhon.Models;

public class Mensajes {
    private int id_mensaje;
    private int id_usuario;
    private String mensaje;
    private String autor_mensaje;
    private String fecha_mensaje;

    

    public Mensajes() {
    }
    

    public Mensajes(int id_mensaje, int id_usuario, String mensaje, String autor_mensaje, String fecha_mensaje) {
        this.id_mensaje = id_mensaje;
        this.id_usuario = id_usuario;
        this.mensaje = mensaje;
        this.autor_mensaje = autor_mensaje;
        this.fecha_mensaje = fecha_mensaje;
    }


    public int getId_usuario() {
        return id_usuario;
    }


    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor_mensaje() {
        return autor_mensaje;
    }

    public void setAutor_mensaje(String autor_mensaje) {
        this.autor_mensaje = autor_mensaje;
    }

    public String getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(String fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }


    @Override
    public String toString() {
        return "Mensajes [id_mensaje=" + id_mensaje + ", id_usuario=" + id_usuario + ", mensaje=" + mensaje
                + ", autor_mensaje=" + autor_mensaje + ", fecha_mensaje=" + fecha_mensaje + "]";
    }

    

}
