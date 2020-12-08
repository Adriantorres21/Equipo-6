package Controlador;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Eliminar_Usuario {

    public void drop_user(int id, JTable tabla) throws SQLException {
        try {
            Connection con = ConexionBD.getConexionMysql();

            int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta seguro de borrar el usuario seleccionado?");
            if (confirmar == 0) {
                String borrar_usu_rol = "DELETE FROM usu_rol WHERE idUsuario=" + id;
                String borrar_login = "DELETE FROM login WHERE idUsuario=" + id;
                String borrar_usuario = "DELETE FROM usuario WHERE idUsuario=" + id;

                PreparedStatement p;
                p = con.prepareStatement(borrar_usu_rol);
                p.executeUpdate();
                p = con.prepareStatement(borrar_login);
                p.executeUpdate();
                p = con.prepareStatement(borrar_usuario);
                p.executeUpdate();

                JOptionPane.showMessageDialog(null, "Usuario Borrado");

                String consulta = "SELECT * FROM usuario";
                Statement s = con.createStatement();
                ResultSet rs = s.executeQuery(consulta);

                String columnas[] = {"idUsuario", "nombre", "apPaterno", "apMaterno",
                    "col", "calle", "numCalle", "tel", "fechaNa"};

                DefaultTableModel tablaModelo = new DefaultTableModel(null, columnas) {
                    public boolean isCellEditable(int Row, int Column) {
                        return false;
                    }
                };

                String registros[] = new String[9];
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

                    tablaModelo.addRow(registros);
                    tabla.setModel(tablaModelo);
                }
            }
            con.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error",
                    e.getMessage(), JOptionPane.WARNING_MESSAGE);
        }
    }
}
