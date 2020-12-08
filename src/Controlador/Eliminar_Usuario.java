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

    public void drop_user(int id) throws SQLException {
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
            }
            else{
                
            }
            con.close();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error",
                    e.getMessage(), JOptionPane.WARNING_MESSAGE);
        }
    }
}
