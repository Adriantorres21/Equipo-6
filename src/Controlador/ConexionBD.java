/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class ConexionBD {
    //sql server
    static Connection contacto = null;
    //mysql
    private static String driver = "com.mysql.jdbc.Driver";
    private static String cadenaConeccion ="jdbc:mysql://127.0.0.1/Panaderia_Reparto";
    private static String usuario="root";
    private static String contra="";
    public static Connection conMysql;

    public static Connection getConexionSQL() {
//        DESKTOP-JH0QBD0
        String url = "jdbc:sqlserver://AdrianTorres:1433;databaseName=Panaderia_Reparto;";
        try {               //com.microsoft.sqlserver.jdbc
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Coneccion exitosa");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion, REVISAR DRIVER " + e.getMessage(),
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        try {
            contacto = DriverManager.getConnection(url,"sa", "adriantorr9");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion, REVISAR DRIVER " + e.getMessage(),
                    "Error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
    
    public static Connection getConexionMysql(){
        try{
            Class.forName(driver);
            conMysql=DriverManager.getConnection(cadenaConeccion, usuario, contra);
            System.out.println("Conexion mysql exitosa");
        }catch(Exception e){
            System.out.println(e);
        }
        return conMysql;
    }


    public static void main(String[] args) {
        try {
            Connection con = ConexionBD.getConexionSQL();
            con.close();
            Connection conn = ConexionBD.getConexionMysql();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
