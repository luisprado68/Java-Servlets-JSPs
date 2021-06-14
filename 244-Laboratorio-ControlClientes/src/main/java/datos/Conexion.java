package datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JBDC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDB_USER = "root";
    private static final String JDB_PASSWORD = "admin";

    public static DataSource getDataSource() throws SQLException {

        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JBDC_URL);
        ds.setUsername(JDB_USER);
        ds.setPassword(JDB_PASSWORD);
        ds.setInitialSize(50);
        return ds;
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
