/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Controlador.ConexionBD;
import Modelo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class RolSQL{
    public static ArrayList<Rol> getListRol() {
        ArrayList<Rol> rol = new ArrayList<Rol>();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        Rol ro = null;
        String sql = "SELECT * FROM rol";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ro = new Rol();
                ro.setIdRol(Integer.parseInt(rs.getString(1)));
                ro.setTipo(rs.getString(2));
                if (rol.isEmpty()) {
                    rol.add(0, ro);
                } else {
                    rol.add(ro);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return rol;
    }
}
