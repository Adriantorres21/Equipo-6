/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablas;

import Controlador.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Modelo.Usuario;

/**
 *
 * @author ADMIN
 */
public class UsuarioSQL {
    public static String registrarUsuario(Usuario usu) {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        String sql = "INSERT INTO usuario values(null,?,?,?,?,?,?,?,?)";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, usu.getNom_usu());
            pst.setString(2, usu.getApellidoP_usu());
            pst.setString(3, usu.getApellidoM_usu());
            pst.setString(4, usu.getColonia());
            pst.setString(5, usu.getCalle());
            pst.setString(6, usu.getNumero());
            pst.setString(7, usu.getTelefono());
            pst.setString(8, usu.getFe_naci());
            pst.execute();
            pst = cn.prepareStatement("SELECT MAX(idUsuario) AS id FROM usuario");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                last = rs.getString(1);
            }
            result = "Usuario registrado con exito, ID:" + last;
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

    public static String actualizarUsuario(Usuario usu) {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        String sql = "UPDATE usuario SET nombre=?,apPaterno=?,apMaterno=?,col=?,calle=?,numCalle=?,tel=?,fechaNa=?, WHERE idUsuario=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, usu.getNom_usu());
            pst.setString(2, usu.getApellidoP_usu());
            pst.setString(3, usu.getApellidoM_usu());
            pst.setString(4, usu.getColonia());
            pst.setString(5, usu.getCalle());
            pst.setString(6, usu.getNumero());
            pst.setString(7, usu.getTelefono());
            pst.setString(8, usu.getFe_naci());
            pst.setInt(9, usu.getId_usuario());
            pst.execute();

            result = "Usuario actualizado con exito, ID:" + usu.getId_usuario();
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

    public static Usuario buscarUsuario(String clave) {
        Usuario usu = new Usuario();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                usu.setId_usuario(Integer.parseInt(rs.getString(1)));
                usu.setNom_usu(rs.getString(2));
                usu.setApellidoP_usu(rs.getString(3));
                usu.setApellidoM_usu(rs.getString(4));
                usu.setColonia(rs.getString(5));
                usu.setCalle(rs.getString(6));
                usu.setNumero(rs.getString(7));
                usu.setTelefono(rs.getString(8));
                usu.setFe_naci(rs.getString(9));
            }
            usu.setResultado("Busqueda exitosa");
        } catch (SQLException e) {
            usu.setResultado("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                usu.setResultado("Error: " + e);
            }
        }
        return usu;
    }

    public static String eliminarUsuario(String clave) {
        String result = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            pst.executeUpdate();
            result = "Usuario eliminado con exito";
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

    public static ArrayList<Usuario> getListUsuario() {
        ArrayList<Usuario> arrUsu = new ArrayList<Usuario>();
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        Usuario usu = null;
        String sql = "SELECT * FROM usuario";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                usu = new Usuario();
                usu.setId_usuario(Integer.parseInt(rs.getString(1)));
                usu.setNom_usu(rs.getString(2));
                usu.setApellidoP_usu(rs.getString(3));
                usu.setApellidoM_usu(rs.getString(4));
                usu.setColonia(rs.getString(5));
                usu.setCalle(rs.getString(6));
                usu.setNumero(rs.getString(7));
                usu.setTelefono(rs.getString(8));
                usu.setFe_naci(rs.getString(9));
                if (arrUsu.isEmpty()) {
                    arrUsu.add(0, usu);
                } else {
                    arrUsu.add(usu);
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
        return arrUsu;
    }
    
    public static String MaxUsuario() {
        String result = null, last = null;
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.getConexionMysql();
        PreparedStatement pst = null;
        try {
            pst = cn.prepareStatement("SELECT MAX(idUsuario) AS id FROM usuario");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                last = rs.getString(1);
            }
            result = last;
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

