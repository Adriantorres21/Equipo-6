/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
}
