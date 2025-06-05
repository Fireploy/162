/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Red.BaseDeDatos;
import Test.TestConection;
import entity.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class TipoDocumentoRepository implements ITipoDocumentoRepository {

    public List<TipoDocumento> consultar() {
        List<TipoDocumento> tiposDocumentos = new ArrayList<>();
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT id, nombre FROM tipo_documento";
            sentencia = con.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            //Recorrer el resultado, dentro de get enviar el nombre exacto del dato
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                TipoDocumento tipoDocumento = new TipoDocumento(id, nombre);
                tiposDocumentos.add(tipoDocumento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Las conexiones se cierran en el orden contrario al que se abrieron. Tenemos que asegurar que cierre
        //en el bloque finally
        finally {
            //Tenemos que estar abriendo y cerradno las conexiones ´por cuestiones de rendimiento. Hacer para 
            //todos los metododos;
            try {
                BaseDeDatos.close(resultado);
                BaseDeDatos.close(sentencia);
                BaseDeDatos.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(TipoDocumentoRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return tiposDocumentos;
    }

    //SELECT * FROM tipo_documento WHERE nombre LIKE "C%"; El porcentaje indica que despues de ese puede haber lo que sea
    //No abusar del SELECT, usar el lenguaje para tomar datos especificos (por ejemplo, promedio entre 4 
    //y 5)
    //Cada vez que tenemos que hacer una consulta tenemos que abrir la conexion
    public TipoDocumento consultarId(TipoDocumento tipoDocumento) {
        TipoDocumento rTipoDocumento = null;
        try {
            Connection con = BaseDeDatos.getConnection();
            //Se prepara la sentencia (?)
            String sql = "SELECT id, nombre FROM tipo_documento WHERE id = ?";
            PreparedStatement sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            //La sentencia con este metodo recibe primero el indice del interrogación y el valor a reemplazar
            sentencia.setInt(1, tipoDocumento.getId());
            ResultSet resultado = sentencia.executeQuery();
            resultado.absolute(1);
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            rTipoDocumento = new TipoDocumento(id, nombre);

        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rTipoDocumento;
    }

    public int insertar(TipoDocumento tipoDocumento) {
        int registro = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "INSERT INTO tipo_documento (nombre) VALUES (?)";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, tipoDocumento.getNombre());
            registro = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    public int eliminar(TipoDocumento tipoDocumento) {
        int borrar = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "DELETE FROM tipo_documento WHERE id = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, tipoDocumento.getId());
            borrar = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borrar;
    }

    //En la practica se cambia es el registro completo. Reemplaza registro completo
    //UPDATE tipo_documento SET nombre = "CEDULA" WHERE id = 1;
    public int actualizar(TipoDocumento tipoDocumento) {
        int actualizar = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "UPDATE tipo_documento SET nombre = ? WHERE id = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, tipoDocumento.getNombre());
            sentencia.setInt(2, tipoDocumento.getId());
            actualizar = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actualizar;
    }

}
