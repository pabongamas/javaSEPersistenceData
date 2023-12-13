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

        List<Mensajes> listaMensajes = new ArrayList<>();

        try (Connection conexion = conexiondb.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mensajes mensaje = new Mensajes();
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
        Conexion conexiondb = new Conexion();
        try (Connection conexion = conexiondb.get_connection()) {
            PreparedStatement statement = null;
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje=?";
                statement = conexion.prepareStatement(query);
                statement.setInt(1, idMensaje);
                int countRowsUpdated = statement.executeUpdate();
                if (countRowsUpdated != 0) {
                    System.out.println("El mensaje ha sido borrado");
                } else {
                    System.out.println("No se ha encontrado este mensaje para borrar");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    public static void actualizarMensajeDB(Mensajes mensaje) {
          Conexion conexiondb = new Conexion();
        try (Connection conexion = conexiondb.get_connection()) {
            PreparedStatement statement = null;
            try {
                String query = "UPDATE mensajes SET mensaje=? WHERE id_mensaje=?";
                statement = conexion.prepareStatement(query);
                statement.setString(1, mensaje.getMensaje());
                statement.setInt(2,mensaje.getId_mensaje());
                int countRowsUpdated = statement.executeUpdate();
                if (countRowsUpdated != 0) {
                    System.out.println("El mensaje ha sido Actualizado");
                } else {
                    System.out.println("No se ha encontrado Mensaje para actualizar");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
