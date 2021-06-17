package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JBDC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDB_USER = "root";
    private static final String JDB_PASSWORD = "admin";
    private static BasicDataSource datasource;

    public static DataSource getDataSource() throws SQLException {
        
        if(datasource == null){
            
            datasource = new BasicDataSource();
            datasource.setUrl(JBDC_URL);
            datasource.setUsername(JDB_USER);
            datasource.setPassword(JDB_PASSWORD);
            datasource.setInitialSize(50);
            
        }
        return datasource;
        
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    //generamosm sobre carga de metodos para cerrar
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }

    public static void close(Statement smtm) {
        try {
            smtm.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    //prepateStatement tiene mejor perfomance 
    public static void close(PreparedStatement smtm)  {
        try {
            smtm.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conexion){
        try {
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
