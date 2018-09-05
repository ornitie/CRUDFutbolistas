/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Date;

/**
 *
 * @author usuario
 */
public class Futbolista {
    
    private String cedula, nombre;
    private double estatura;
    private String posicion;
    private int dorsal;
    private Date fechaNacimiento;
    private double peso;

    public Futbolista() {
    }
    public Futbolista(String cedula, String nombre, double estatura, String posicion, Date fechaNacimiento, int dorsal, double peso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.estatura = estatura;
        this.posicion = posicion;
        this.fechaNacimiento = fechaNacimiento;
        this.dorsal = dorsal;
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getEstatura() {
        return estatura;
    }
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setEdad(String posicion) {
        this.posicion = posicion;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    
}
