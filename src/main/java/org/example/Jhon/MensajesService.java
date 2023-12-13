package org.example.Jhon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.example.Jhon.Models.Mensajes;

public class MensajesService {
    public static void crearMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe Tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Escribe el id del usuario del mensaje");
        int id_usuario = Integer.parseInt(sc.nextLine());

        java.util.Date fechaActual = new java.util.Date();

        // Formatear la fecha como una cadena en el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = sdf.format(fechaActual);

        Mensajes nuevoMensaje = new Mensajes();
        nuevoMensaje.setId_usuario(id_usuario);
        nuevoMensaje.setMensaje(mensaje);
        nuevoMensaje.setFecha_mensaje(fechaFormateada);
        MensajesDAO.crearMensajeDB(nuevoMensaje);
    }

    public static void listarMensajes() {
        List<Mensajes> mensajesLista = MensajesDAO.leerMensajesDB();
        System.out.println("-------------Lista de mensajes-------------");
        for (Mensajes mensaje : mensajesLista) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Id Mensaje: " + mensaje.getId_mensaje());
            System.out.println("Id Usuario: " + mensaje.getId_usuario());
            System.out.println("Mensaje: " + mensaje.getMensaje());
            System.out.println("Fecha Mensaje: " + mensaje.getFecha_mensaje());
        }

        System.out.println("\n\nSe han listado un total de  " + mensajesLista.size() + " mensajes.");
    }

    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el id del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }

    public static void editarMensaje() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe el nuevo mensaje ");
        String mensajeString = sc.nextLine();
        
        System.out.println("Indica el id del mensaje a Actualizar ");
        int id_mensaje = sc.nextInt();
        Mensajes mensaje = new Mensajes();
        mensaje.setId_mensaje(id_mensaje);
        mensaje.setMensaje(mensajeString);
        MensajesDAO.actualizarMensajeDB(mensaje);

    }
}
