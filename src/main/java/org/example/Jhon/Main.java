package org.example.Jhon;

import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      Conexion conexion=new Conexion();
      try (Connection conx=conexion.get_connection()){
        
      } catch (Exception e) {
        System.out.println(e);
      }
    }
}