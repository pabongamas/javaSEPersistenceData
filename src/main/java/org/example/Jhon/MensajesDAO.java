package org.example.Jhon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.Jhon.Models.Mensajes;

public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje) {
        Conexion conexiondb = new Conexion();

        try (Connection conexion = conexiondb.get_connection()) {
            PreparedStatement ps=null;
            try{
                String query="";
            } catch (Exception e) {
                // TODO: handle exception
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void leerMensajesDB() {

    }

    public static void borrarMensajeDB(int idMensaje) {

    }

    public static void actualizarMensajeDB(Mensajes mensaje) {

    }

}
