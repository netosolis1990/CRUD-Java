/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netosolis.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author netosolis.com
 */
public class CRUD {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public CRUD() {
        try{
            if((con = conexion.getConexionMYSQL())==null){
                JOptionPane.showMessageDialog(null,"Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Inserta una nueva pelicula en la Base de Datos
    public boolean insert(String nombre,String genero,int anio,String actor,String pais){
        try {
            String query = "INSERT INTO peliculas VALUES(NULL,'"+nombre+"','"+genero+"','"+anio+"','"+actor+"','"+pais+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Devuelve el resultset con los datos de peliculas
    public ResultSet selectXtodas(){
        try {
            String query = "SELECT * FROM peliculas";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Devuelve el resultset con los datos de peliculas con select por genero
    public ResultSet selectXgenero(String genero){
        try {
            String query = "SELECT * FROM peliculas WHERE genero = '"+genero+"'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Devuelve el resultset con los datos de peliculas con select por pais
    public ResultSet selectXpais(String pais){
        try {
            String query = "SELECT * FROM peliculas WHERE pais = '"+pais+"'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    //Elimina la pelicula
    public boolean delete(int id){
        try {
            String query = "DELETE FROM peliculas WHERE id = '"+id+"'";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Actualiza los datos de la pelicula
    public boolean update(int id,String nombre,String genero,int anio,String actor,String pais){
        try {
            String query = "UPDATE peliculas SET"
                    + " nombre = '"+nombre+"',"
                    + " genero = '"+genero+"',"
                    + " anio = '"+anio+"',"
                    + " actor = '"+actor+"',"
                    + " pais = '"+pais+"' WHERE id = '"+id+"';";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
