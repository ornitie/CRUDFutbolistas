/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import DB.Conexion;
import View.IVentanas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class ServicioFutbolista {
    
    private Conexion conexion;
    private ArrayList<IVentanas> hijos;

    public ServicioFutbolista() {
        conexion = new Conexion();
        hijos = new ArrayList<>();
    }
    
    public void agregarHijos(IVentanas hijo){
        hijos.add(hijo);
    }
    
    public void cerrarConexion(){
        conexion.closeConecction();
    }
    
    public void insertar(Futbolista f){
       boolean r = conexion.executeUpdateStatement("INSERT INTO FUTBOLISTAS VALUES('"+
                f.getCedula()+"','"+f.getNombre()+"',"+f.getEstatura()+",'"+
                f.getPosicion()+"', TO_DATE('"+f.getFechaNacimiento().toString()+"','YYYY-MM-DD'),"+f.getDorsal()+","+f.getPeso()+")");
       System.out.println("INSERT INTO FUTBOLISTAS VALUES('"+
                f.getCedula()+"','"+f.getNombre()+"',"+f.getEstatura()+",'"+
                f.getPosicion()+"', TO_DATE('"+f.getFechaNacimiento().toString()+"','YYYY-MM-DD'),"+f.getDorsal()+","+f.getPeso()+")");
       for(IVentanas i:hijos){
            i.ActualizarJugador();
        }
        if(r) JOptionPane.showMessageDialog(null, "Se agregó satisfactoriamente");
    }
    
    public void actualizar(Futbolista f){
        boolean r =conexion.executeUpdateStatement("UPDATE FUTBOLISTAS SET NOMBRE='"+f.getNombre()
                +"', ESTATURA="+f.getEstatura()+", POSICION = '"+f.getPosicion()+
                "', FECHA_NACIMIENTO = TO_DATE('"+f.getFechaNacimiento().toString()+
                "','YYYY-MM-DD'), DORSAL = "+f.getDorsal()+", PESO="+f.getPeso()+" WHERE CEDULA = '"+f.getCedula()+"'");
        for(IVentanas i:hijos){
            i.ActualizarJugador();
        }
        if(r) JOptionPane.showMessageDialog(null, "Se actualizó satisfactoriamente");
    }
    
    public void eliminar(String id){
        boolean r = conexion.executeUpdateStatement("DELETE FROM FUTBOLISTAS WHERE CEDULA = '"+id+"'");
        for(IVentanas i:hijos){
            i.ActualizarJugador();
        }
        if(r) JOptionPane.showMessageDialog(null, "Se eliminó satisfactoriamente");
    }
    
    public Futbolista buscar(String id){
        ResultSet rs = conexion.executeQueryStatement("SELECT * FROM FUTBOLISTAS WHERE CEDULA = '"+id+"'");
        try {
            while(rs.next()){
                return new Futbolista(id, rs.getString("NOMBRE"), rs.getDouble("ESTATURA"), 
                        rs.getString("POSICION"),rs.getDate("FECHA_NACIMIENTO"), rs.getInt("DORSAL"), rs.getDouble("PESO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioFutbolista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Futbolista> listar(){
        List<Futbolista> lista = new ArrayList<>();
        ResultSet rs = conexion.executeQueryStatement("SELECT * FROM FUTBOLISTAS");
        try {
            while(rs.next()){
                lista.add( new Futbolista(rs.getString("CEDULA"), rs.getString("NOMBRE"), rs.getDouble("ESTATURA"), 
                        rs.getString("POSICION"),rs.getDate("FECHA_NACIMIENTO"), rs.getInt("DORSAL"), rs.getDouble("PESO")) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioFutbolista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
    
}
