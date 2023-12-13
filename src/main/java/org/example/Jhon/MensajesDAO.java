package org.example.Jhon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.Jhon.Models.Mensajes;

public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje) {
         Conexion conexiondb = new Conexion();
        try (Connection conexion = conexiondb.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (id_usuario,mensaje,fecha) VALUES (?,?,?)";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, mensaje.getId_usuario());
                ps.setString(2, mensaje.getMensaje());
                ps.setString(3, mensaje.getFecha_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje Creado");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static List<Mensajes> leerMensajesDB() {
        Conexion conexiondb = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Mensajes>listaMensajes=new ArrayList<>();

        try (Connection conexion = conexiondb.get_connection()) {
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()) {
                Mensajes mensaje=new Mensajes();
                mensaje.setId_mensaje(rs.getInt(1));
                mensaje.setId_usuario(rs.getInt(2));
                mensaje.setMensaje(rs.getString(3));
                mensaje.setFecha_mensaje(rs.getString(4));
                listaMensajes.add(mensaje);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listaMensajes;
    }

    public static void borrarMensajeDB(int idMensaje) {

    }

    public static void actualizarMensajeDB(Mensajes mensaje) {

    }

}
