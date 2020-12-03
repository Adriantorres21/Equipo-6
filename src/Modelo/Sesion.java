/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ConexionBD;
import Vista.Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class Sesion {

    private Integer idLogin;
    private Integer idUsuario;
    private String cuenta;
    private String pswd;
    private String resultado;

    Connection cn = ConexionBD.getConexionMysql();

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void verificarLogin(JTextField usu, JPasswordField pass,
            JFrame vent) throws SQLException {
        try {
            String consulta = "SELECT * FROM login WHERE cuenta = '" + usu.getText() + "' "
                    + "AND pswd = '" + pass.getText() + "'";
            Statement s = cn.createStatement();
            ResultSet resultado = s.executeQuery(consulta);

            if (resultado.next()) {
                Menu m = new Menu();
                m.setVisible(true);
                vent.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña invalida",
                         "Campos incorrectos", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
