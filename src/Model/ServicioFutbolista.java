/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import DB.Conexion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class ServicioFutbolista {
    Conexion conexion;

    public ServicioFutbolista() {
        conexion = new Conexion();
        ResultSet rs = conexion.executeQueryStatement("SELECT * FROM FUTBOLISTAS");
        try {
            while(rs.next()){
            JOptionPane.showMessageDialog(null, rs.getString(2));
            }
            conexion.closeConecction();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioFutbolista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertar(Futbolista f){
        conexion.executeUpdateStatement("INSERT INTO FUTBOLISTAS VALUES('"+
                f.getCedula()+"','"+f.getNombre()+"',"+f.getEstatura()+","+
                f.getEdad()+", TO_DATE('"+f.getFechaNacimiento()+"','DD/MM/YYYY')"+")");
    }
    
    public static void main(String[] args){
        ServicioFutbolista sf = new ServicioFutbolista();
    }
    
}
