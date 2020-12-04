/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrian
 */
public class ConsultaRepProceso {

    public void llenarTbProceso(JTable tbProcess) {
        try {
            Connection conn = ConexionBD.getConexionMysql();
            String consulta = "SELECT u.idUsuario, u.nombre,u.apPaterno,\n"
                    + "r.idReparto, p.nombre, pr.cantidad,\n"
                    + "r.fecha, r.horaSalida\n"
                    + "FROM usuario u\n"
                    + "INNER JOIN reparto r \n"
                    + "ON r.idUsuario = u.idUsuario\n"
                    + "INNER JOIN prod_rep pr \n"
                    + "ON pr.idReparto = r.idReparto\n"
                    + "INNER JOIN producto p \n"
                    + "ON p.idProducto = pr.idProducto\n"
                    + "WHERE r.estado ='En Proceso' ORDER BY r.idReparto";

            Statement s = conn.createStatement();
            ResultSet resultado = s.executeQuery(consulta);

            String titulos[] = {"idUsuario", "nombre", "apPaterno", "idReparto",
                "producto", "cantidad", "fecha", "horaSalida"};

            DefaultTableModel tabla = new DefaultTableModel(null, titulos) {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };

            String registros[] = new String[8];

            while (resultado.next()) {
                registros[0] = resultado.getString("u.idUsuario");
                registros[1] = resultado.getString("u.nombre");
                registros[2] = resultado.getString("u.apPaterno");
                registros[3] = resultado.getString("r.idReparto");
                registros[4] = resultado.getString("p.nombre");
                registros[5] = resultado.getString("pr.cantidad");
                registros[6] = resultado.getString("r.fecha");
                registros[7] = resultado.getString("r.horaSalida");
                tabla.addRow(registros);
            }
            tbProcess.setModel(tabla);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
