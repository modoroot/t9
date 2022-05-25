package actividades.uno;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase que conecta a la DB
 * 
 * @author amna
 * @version 1.0
 */
public class DbConn {
	private final String URL = "jdbc:mysql://localhost:3306/planetas";
    private final String USER = "usuario";
    private final String CLAVE = "usuario";
      
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
