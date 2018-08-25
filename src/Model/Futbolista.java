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
    private String fechaNacimiento;
    private int dorsal;

    public Futbolista() {
    }
    public Futbolista(String cedula, String nombre, double estatura, String posicion, String fechaNacimiento, int dorsal) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.estatura = estatura;
        this.posicion = posicion;
        this.fechaNacimiento = fechaNacimiento;
        this.dorsal = dorsal;
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
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    
}
