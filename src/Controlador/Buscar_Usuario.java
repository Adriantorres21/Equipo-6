package Controlador;

import Vista.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Buscar_Usuario {

    Connection conn = ConexionBD.getConexionMysql();

    public void Usuario(String usuario, JTable tablavista) {
        try {
            int idUsuario = Integer.parseInt(usuario);

            Statement s = conn.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM usuario "
                    + "WHERE idUsuario=" + idUsuario);

            String titulos[] = {"idUsuario", "nombre", "apPaterno", "apMaterno",
                "col", "calle", "numCalle", "tel", "fechaNa"};
            DefaultTableModel tabla = new DefaultTableModel(null, titulos) {
                public boolean isCellEditable(int Row, int Column) {
                    return false;
                }
            };

            String registros[] = new String[9];
            while (resultado.next()) {
                registros[0] = resultado.getString(1);
                registros[1] = resultado.getString(2);
                registros[2] = resultado.getString(3);
                registros[3] = resultado.getString(4);
                registros[4] = resultado.getString(5);
                registros[5] = resultado.getString(6);
                registros[6] = resultado.getString(7);
                registros[7] = resultado.getString(8);
                registros[8] = resultado.getString(9);

                tabla.addRow(registros);
                tablavista.setModel(tabla);
            }

//                String registros[] = new String[9];
//                DefaultTableModel tabla;
//                tabla = new DefaultTableModel(null, titulos);
//                
//                while(resultado.next()){
//                    usuario us = new usuario(idUsuario,resultado.getString(2),
//                    resultado.getString(3),resultado.getString(4),
//                    resultado.getString(5),resultado.getString(6),
//                    resultado.getString(7),resultado.getString(8),
//                    resultado.getDate(9));
//                }
//               
            conn.close();
        } catch (Exception e) {
        }
    }
}
