package Controlador;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class Consulta_Historial {

    Connection con = ConexionBD.getConexionMysql();

    public void consultar_historial_ID(String ID, JDateChooser fecha1,
            JDateChooser fecha2, JTable tabla) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            String fecha_inicial = f.format(fecha1.getDate());
            String fecha_final = f.format(fecha2.getDate());

            String consulta = "SELECT u.idUsuario, u.nombre, r.idReparto, r.fecha, "
                    + "r.horaSalida, r.horaRegreso, p.nombre, pr.cantidad, v.total, d.total\n"
                    + "FROM usuario u\n"
                    + "INNER JOIN reparto r ON r.idUsuario = u.idUsuario\n"
                    + "INNER JOIN devolucion d ON d.idReparto = r.idReparto\n"
                    + "INNER JOIN venta v ON v.idReparto = r.idReparto\n"
                    + "INNER JOIN prod_rep pr ON pr.idReparto = r.idReparto\n"
                    + "INNER JOIN producto p ON p.idProducto = pr.idProducto\n"
                    + "WHERE r.estado = 'Finalizado'\n"
                    + "AND r.fecha >= '" + fecha_inicial + "'\n"
                    + "AND r.fecha <= '" + fecha_final + "'\n"
                    + "AND u.IdUsuario =" + ID
                    + "ORDER BY u.IdUsuario";

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            String columnas[] = {"idUsuario", "Nombre", "idReparto", "Fecha",
                "Hora Salida", "Hora Regreso", "Producto", "Cantidad", "Total",
                "Total"};
            DefaultTableModel tablaModelo = new DefaultTableModel(null, columnas) {
                public boolean isCellEditable(int Row, int Column) {
                    return false;
                }
            };

            String registros[] = new String[10];

            boolean encontrado = rs.next();
            if (encontrado == false) {
                JOptionPane.showMessageDialog(null, "No se encuentras registros");
            } else {
                while (rs.next()) {
                    registros[0] = rs.getString(1);
                    registros[1] = rs.getString(2);
                    registros[2] = rs.getString(3);
                    registros[3] = rs.getString(4);
                    registros[4] = rs.getString(5);
                    registros[5] = rs.getString(6);
                    registros[6] = rs.getString(7);
                    registros[7] = rs.getString(8);
                    registros[8] = rs.getString(9);
                    registros[9] = rs.getString(10);

                    tablaModelo.addRow(registros);
                    tabla.setModel(tablaModelo);
                }
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error",
                    "Error al procesar la consulta", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void consultar_historial(JDateChooser fecha1, JDateChooser fecha2, JTable tabla) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            String fecha_inicial = f.format(fecha1.getDate());
            String fecha_final = f.format(fecha2.getDate());

            String consulta = "SELECT u.idUsuario, u.nombre, r.idReparto, r.fecha, r.horaSalida, "
                    + "r.horaRegreso, p.nombre, pr.cantidad, v.total, d.total FROM usuario u "
                    + "INNER JOIN reparto r ON r.idUsuario = u.idUsuario INNER JOIN devolucion d "
                    + "ON d.idReparto = r.idReparto INNER JOIN venta v ON v.idReparto = r.idReparto "
                    + "INNER JOIN prod_rep pr ON pr.idReparto = r.idReparto INNER JOIN producto "
                    + "p ON p.idProducto = pr.idProducto "
                    + "WHERE r.estado = 'Finalizado' "
                    + "AND r.fecha >= '" + fecha_inicial + "' AND r.fecha <= '"
                    + fecha_final + "' "
                    + "ORDER BY u.IdUsuario";

            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(consulta);

            String columnas[] = {"idUsuario", "Nombre", "idReparto", "Fecha",
                "Hora Salida", "Hora Regreso", "Producto", "Cantidad", "Total",
                "Total"};
            DefaultTableModel tablaModelo = new DefaultTableModel(null, columnas) {
                public boolean isCellEditable(int Row, int Column) {
                    return false;
                }
            };

            String registros[] = new String[10];
            boolean encontrado = rs.next();
            if (encontrado == false) {
                JOptionPane.showMessageDialog(null, "No se encuentras registros");
            } else {
                while (rs.next()) {
                    registros[0] = rs.getString(1);
                    registros[1] = rs.getString(2);
                    registros[2] = rs.getString(3);
                    registros[3] = rs.getString(4);
                    registros[4] = rs.getString(5);
                    registros[5] = rs.getString(6);
                    registros[6] = rs.getString(7);
                    registros[7] = rs.getString(8);
                    registros[8] = rs.getString(9);
                    registros[9] = rs.getString(10);

                    tablaModelo.addRow(registros);
                    tabla.setModel(tablaModelo);
                }
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error",
                    "Error al procesar la consulta", JOptionPane.WARNING_MESSAGE);
        }
    }
}
