/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ConexionBD;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Usuario {

    private Integer id_usuario;
    private String nom_usu;
    private String apellidoP_usu;
    private String apellidoM_usu;
    private String colonia;
    private String calle;
    private String numero;
    private String tel;
    private String fe_naci;
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getApellidoP_usu() {
        return apellidoP_usu;
    }

    public void setApellidoP_usu(String apellidoP_usu) {
        this.apellidoP_usu = apellidoP_usu;
    }

    public String getApellidoM_usu() {
        return apellidoM_usu;
    }

    public void setApellidoM_usu(String apellidoM_usu) {
        this.apellidoM_usu = apellidoM_usu;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefono() {
        return tel;
    }

    public void setTelefono(String tel) {
        this.tel = tel;
    }

    public String getFe_naci() {
        return fe_naci;
    }

    public void setFe_naci(String fe_naci) {
        this.fe_naci = fe_naci;
    }

    @Override
    public String toString() {
        return nom_usu;
    }

    public void usuario(JTable tbUsu) {
        try {

            Connection conn = ConexionBD.getConexionMysql();
            Statement s = conn.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM usuario ");

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
            }
            tbUsu.setModel(tabla);
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void obtenerUsuario1(int id, JTextField n, JTextField apP, JTextField apM,
            JDateChooser fe, JTextField tel, JTextField calle, JTextField num,
            JTextField col, JTextField cuenta, JPasswordField pass, JComboBox cb) {
        try {
            String consulta = "SELECT ur.idRol, u.nombre, u.apPaterno, u.apMaterno, "
                    + "u.fechaNa, u.tel, u.calle, u.numCalle, u.col, l.cuenta, l.pswd\n"
                    + "FROM usuario u\n"
                    + "INNER JOIN login l ON l.idUsuario = u.idUsuario\n"
                    + "INNER JOIN usu_rol ur ON ur.idUsuario = u.idUsuario\n"
                    + "WHERE u.idUsuario =" + id;
            Connection conn = ConexionBD.getConexionMysql();
            Statement s = conn.createStatement();
            ResultSet resultado = s.executeQuery(consulta);
            if (resultado.next()) {
                n.setText(resultado.getString("u.nombre"));
                apP.setText(resultado.getString("u.apPaterno"));
                apM.setText(resultado.getString("u.apMaterno"));
                fe.setDate(resultado.getDate("u.fechaNa"));
                tel.setText(resultado.getString("u.tel"));
                calle.setText(resultado.getString("u.calle"));
                num.setText(resultado.getString("u.numCalle"));
                col.setText(resultado.getString("u.col"));
                cuenta.setText(resultado.getString("l.cuenta"));
                pass.setText(resultado.getString("l.pswd"));
                cb.setSelectedItem(resultado.getString("ur.idRol"));
                cb.enable(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void obtenerUsuario2(int id, JTextField n, JTextField apP, JTextField apM,
            JDateChooser fe, JTextField tel, JTextField calle, JTextField num,
            JTextField col, JComboBox cb) {
        try {
            String consulta = "SELECT ur.idRol, u.nombre, u.apPaterno, u.apMaterno,\n"
                    + "u.fechaNa, u.tel, u.calle, u.numCalle, u.col\n"
                    + "FROM usuario u\n"
                    + "INNER JOIN usu_rol ur ON ur.idUsuario = u.idUsuario\n" 
                    + "WHERE u.idUsuario = "+ id;
            Connection conn = ConexionBD.getConexionMysql();
            Statement s = conn.createStatement();
            ResultSet resultado = s.executeQuery(consulta);
            if (resultado.next()) {
                n.setText(resultado.getString("u.nombre"));
                apP.setText(resultado.getString("u.apPaterno"));
                apM.setText(resultado.getString("u.apMaterno"));
                fe.setDate(resultado.getDate("u.fechaNa"));
                tel.setText(resultado.getString("u.tel"));
                calle.setText(resultado.getString("u.calle"));
                num.setText(resultado.getString("u.numCalle"));
                col.setText(resultado.getString("u.col"));
                cb.setSelectedItem(resultado.getString("ur.idRol"));
                cb.enable(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean verificarLog(int idu) {
        boolean siHay = false;

        try {
            String consulta = "SELECT * FROM login WHERE idUsuario = " + idu;
            Connection conn = ConexionBD.getConexionMysql();
            Statement s = conn.createStatement();
            ResultSet resultado = s.executeQuery(consulta);
            siHay = resultado.next();
            System.out.println(resultado.getString(1));
        } catch (Exception e) {
            System.out.println(e);
        }
        return siHay;
    }
}
