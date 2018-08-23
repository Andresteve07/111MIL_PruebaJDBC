package pruebajdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaJDBC {
    static final String URL_BASE_DE_DATOS = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10253043";
    static final String CONTROLADOR_BASE_DATOS = "com.mysql.jdbc.Driver";
    static final String USUARIO_BASE_DATOS = "sql10253043";
    static final String PASSWORD_BASE_DATOS = "e7pVpksWPQ";

    public static void main(String[] args) {
           System.out.println(obtenerLibroPorID("456789"));
    }
    
    public static Libro obtenerLibroPorID(String idLibro){
        Connection conexion = null;
        PreparedStatement sentenciaParametrizada = null;
        ResultSet resultados = null;
        Libro libroEncontrado = null;
        
        try{
            Class.forName(CONTROLADOR_BASE_DATOS);
            conexion = DriverManager.getConnection(
                    URL_BASE_DE_DATOS,
                    USUARIO_BASE_DATOS,
                    PASSWORD_BASE_DATOS);
            //sentencia = conexion.createStatement();           
            sentenciaParametrizada = conexion.prepareStatement(
                    "SELECT id_libro,titulo,edicion,precio FROM libro WHERE id_libro = ?");
            sentenciaParametrizada.setString(1, idLibro);
            resultados = sentenciaParametrizada.executeQuery();
            if(resultados.next()){
                libroEncontrado = new Libro(
                        resultados.getString(1),
                        resultados.getString(2), 
                        resultados.getString(3), 
                        resultados.getFloat(4));
            }
            return libroEncontrado;
        } catch(SQLException exc){
            exc.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultados.close();
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}