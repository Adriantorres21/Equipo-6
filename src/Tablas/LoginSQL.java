/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Controlador.ConexionBD;
import Modelo.Sesion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class LoginSQL {
    public static String registrarLogin(Sesion log) {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        String sql = "INSERT INTO login values(null,?,?,?)";
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, log.getIdUsuario());
            pst.setString(2, log.getCuenta());
            pst.setString(3, log.getPswd());
            pst.execute();
            pst = cn.prepareStatement("SELECT MAX(idLogin) AS id FROM login");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                last = rs.getString(1);
            }
            result = "Login registrado con exito, ID:" + last;
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

    public static String actualizarLogin(Sesion log) {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        String sql = "UPDATE login SET idUsuario=?,cuenta=?,pswd=? WHERE idLogin=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setInt(1, log.getIdUsuario());
            pst.setString(2, log.getCuenta());
            pst.setString(3, log.getPswd());
            pst.execute();

            result = "Login actualizado con exito, ID:" + log.getIdLogin();
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

    public static Sesion buscarLogin(String clave) {
        Sesion log = new Sesion();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM login WHERE idLogin = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                log.setIdLogin(Integer.parseInt(rs.getString(1)));
                log.setIdUsuario(rs.getInt(2));
                log.setCuenta(rs.getString(3));
                log.setPswd(rs.getString(4));
            }
            log.setResultado("Busqueda exitosa");
        } catch (SQLException e) {
            log.setResultado("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                log.setResultado("Error: " + e);
            }
        }
        return log;
    }

    public static String eliminarLogin(String clave) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        String sql = "DELETE FROM login WHERE idLogin = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            pst.executeUpdate();
            result = "Login eliminado con exito";
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

    public static ArrayList<Sesion> getListLogin() {
        ArrayList<Sesion> lo = new ArrayList<Sesion>();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        Sesion log = null;
        String sql = "SELECT * FROM login";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                log = new Sesion();
                log.setIdLogin(Integer.parseInt(rs.getString(1)));
                log.setIdUsuario(rs.getInt(2));
                log.setCuenta(rs.getString(3));
                log.setPswd(rs.getString(4));
                if (lo.isEmpty()) {
                    lo.add(0, log);
                } else {
                    lo.add(log);
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
        return lo;
    }
}
