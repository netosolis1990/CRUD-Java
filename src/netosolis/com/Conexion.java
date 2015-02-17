package netosolis.com;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author netosolis.com
 */
public class Conexion {
    //Configuracion de los datos de la BD
    private String usuario = "root";
    private String pass = "";
    private String host = "localhost";
    private String nombre_BD = "crudjava";
    
    private Connection con = null;
    
    public Conexion() {
    }
    //Metodo que se devuelve la conexion o null si hubo un error
    public Connection getConexionMYSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
            con = DriverManager.getConnection(servidor,usuario,pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }
    }
}
