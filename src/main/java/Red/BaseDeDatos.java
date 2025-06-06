/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Red;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author estudiante USA PATRON SINGLETON
 */
public class BaseDeDatos {
    public static final String JDBC_URL = "jdbc:mysql://18.209.45.69:3306/1152455?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String DB_USER = "test";
    public static final String DB_CLAVE = "test1_*";	
    
    public static DataSource getDataSource(){
        BasicDataSource bs = new BasicDataSource();
        bs.setUrl(JDBC_URL);
        bs.setUsername(DB_USER);
        bs.setPassword(DB_CLAVE);  
        bs.setInitialSize(5);
        return bs;       
    }
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = getDataSource().getConnection();
        System.out.println("✅ Conexión a la base de datos establecida correctamente");
        return con;
    }
    
    public static void close(Connection con) throws SQLException{
        con.close();
    }
    
    public static void close(Statement sta) throws SQLException{
        sta.close();
    }
    
    public static void close(ResultSet res) throws SQLException{
        res.close();
    }
    
    public static void close(PreparedStatement ps ) throws SQLException{
        ps.close();
    }
}
