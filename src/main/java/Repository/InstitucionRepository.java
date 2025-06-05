/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Red.BaseDeDatos;
import Test.TestConection;
import entity.Institucion;
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
public class InstitucionRepository implements IInstitucionRepository{
    @Override
    public List<Institucion> consultar() {
        List<Institucion> instituciones = new ArrayList<>();
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        try {
            con = BaseDeDatos.getConnection();
            String sql = "SELECT codigo, nombre FROM institución";
            sentencia = con.prepareStatement(sql);
            resultado = sentencia.executeQuery();
            //Recorrer el resultado, dentro de get enviar el nombre exacto del dato
            while (resultado.next()) {
                String codigo = resultado.getString("codigo");
                String nombre = resultado.getString("nombre");
                Institucion institucion  = new Institucion(codigo, nombre);
                instituciones.add(institucion);
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
        return instituciones;
    }

    @Override
    public Institucion consultarId(Institucion institucion) {
        Institucion rInstitucion = null;
        try {
            Connection con = BaseDeDatos.getConnection();
            //Se prepara la sentencia (?)
            String sql = "SELECT codigo, nombre FROM institución WHERE codigo = ?";
            PreparedStatement sentencia = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            //La sentencia con este metodo recibe primero el indice del interrogación y el valor a reemplazar
            sentencia.setString(1, institucion.getCodigo());
            ResultSet resultado = sentencia.executeQuery();
            resultado.absolute(1);
            String codigo  = resultado.getString("codigo");
            String nombre = resultado.getString("nombre");
            rInstitucion = new Institucion(codigo, nombre);

        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rInstitucion;
    }

    @Override
    public int insertar(Institucion institucion) {
        int registro = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "INSERT INTO institución (codigo, nombre) VALUES (?,?)";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, institucion.getCodigo());
            sentencia.setString(2, institucion.getNombre());
            registro = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;
    }

    @Override
    public int eliminar(Institucion institucion) {
        int borrar = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "DELETE FROM institución WHERE codigo = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, institucion.getCodigo());
            borrar = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borrar;
    }

    @Override
    public int actualizar(Institucion institucion) {
         int actualizar = 0;
        try {
            Connection con = BaseDeDatos.getConnection();
            String sql = "UPDATE institución SET nombre = ? WHERE codigo = ?";
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, institucion.getNombre());
            sentencia.setString(2, institucion.getCodigo());
            actualizar = sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actualizar;
    }
}
