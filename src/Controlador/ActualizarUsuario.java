/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Adrian
 */
public class ActualizarUsuario {

    public void hacerCambiosUsuario(int id, JTextField n, JTextField apP, JTextField apM,
            JDateChooser fe, JTextField tel, JTextField calle, JTextField num,
            JTextField col) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            Connection conn = ConexionBD.getConexionMysql();
            PreparedStatement ps;

            String consulta = "UPDATE usuario SET nombre = '" + n.getText() + "',\n"
                    + "apPaterno = '" + apP.getText() + "',\n"
                    + "apMaterno = '" + apM.getText() + "',\n"
                    + "fechaNa = '" + f.format(fe.getDate()) + "',\n"
                    + "tel = '" + tel.getText() + "',\n"
                    + "calle = '" + calle.getText() + "',\n"
                    + "numCalle = '" + num.getText() + "',\n"
                    + "col = '" + col.getText() + "' "
                    + "WHERE idUsuario =" + id;

            ps = conn.prepareStatement(consulta);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos de usuario actualizados"
                    + "Correctamente", "Actualización",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void hacerCambiosLogin(int id, JTextField cuenta, JPasswordField pass) {
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            Connection conn = ConexionBD.getConexionMysql();
            PreparedStatement ps;

            String consulta = "UPDATE login SET\n"
                    + "cuenta = '"+cuenta.getText()+"',\n"
                    + "pswd = '"+pass.getText()+"'\n"
                    + "WHERE idUsuario = "+id;

            ps = conn.prepareStatement(consulta);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Login actualizado"
                    + "Correctamente", "Actualización",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
