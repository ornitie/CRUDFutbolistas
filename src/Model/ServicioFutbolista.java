/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import DB.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ServicioFutbolista {
    Conexion conexion;

    public ServicioFutbolista() {
        conexion = new Conexion();
        buscar("123456789");
        listar();
        conexion.closeConecction();
        
    }
    
    public void insertar(Futbolista f){
        conexion.executeUpdateStatement("INSERT INTO FUTBOLISTAS VALUES('"+
                f.getCedula()+"','"+f.getNombre()+"',"+f.getEstatura()+",'"+
                f.getPosicion()+"', TO_DATE('"+f.getFechaNacimiento()+"','DD/MM/YYYY'), "+f.getDorsal()+")");
    }
    
    public void actualizar(Futbolista f){
        conexion.executeUpdateStatement("UPDATE FUTBOLISTAS SET NOMBRE='"+f.getNombre()
                +"', ESTATURA="+f.getEstatura()+", POSICION = '"+f.getPosicion()+
                "', FECHA_NACIMIENTO = TO_DATE('"+f.getFechaNacimiento()+
                "','DD/MM/YYYY'), DORSAL = "+f.getDorsal()+" WHERE CEDULA = '"+f.getCedula()+"'");
    }
    
    public void eliminar(String id){
        conexion.executeUpdateStatement("DELETE FROM FUTBOLISTAS WHERE CEDULA = '"+id+"'");
    }
    
    public Futbolista buscar(String id){
        ResultSet rs = conexion.executeQueryStatement("SELECT * FROM FUTBOLISTAS WHERE CEDULA = '"+id+"'");
        try {
            while(rs.next()){
                String fecha = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("FECHA_NACIMIENTO"));
                return new Futbolista(id, rs.getString("NOMBRE"), rs.getDouble("ESTATURA"), 
                        rs.getString("POSICION"),fecha, rs.getInt("DORSAL"));
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
                String fecha = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("FECHA_NACIMIENTO"));
                lista.add( new Futbolista(rs.getString("CEDULA"), rs.getString("NOMBRE"), rs.getDouble("ESTATURA"), 
                        rs.getString("POSICION"),fecha, rs.getInt("DORSAL")) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicioFutbolista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static void main(String[] args){
        ServicioFutbolista sf = new ServicioFutbolista();
    }
    
}
