/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Controlador.ConexionBD;
import Modelo.Usu_rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class Usu_RolSQL {
    public static String registrarUsu_Rol(Usu_rol usulog) {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        String sql = "INSERT INTO usu_rol values(null,?,?)";
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, usulog.getIdRol());
            pst.setInt(2, usulog.getIdUsuario());
            pst.execute();
            pst = cn.prepareStatement("SELECT MAX(idReg) AS id FROM usu_rol");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                last = rs.getString(1);
            }
            result = "Relacion usuario y rol registrado con exito, ID:" + last;
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error: " + e;
            }
        }
        return result;
    }
}
