/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Red.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class TestConection {
    public static void main (String [] args){
        //Creamos conexion con la base de datos
        //Creamos sentencia de sql
        //Preparamos la sentencia
        //Ejecuto la sentencia
        //Query solo para consultar, update para cambiar (Eliminar, actulizar, crear)
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "SELECT id, nombre FROM tipo_documento";
            PreparedStatement sentencia = con.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            //Recorrer el resultado, dentro de get enviar el nombre exacto del dato
            while(resultado.next()){
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                System.out.println("ID: " + id + "-- Nombre: " + nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
