/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.IServicios;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Juan Pablo
 */
public class ViewAgregarJugador extends UnicastRemoteObject implements IVentanas, Serializable{    
    public static long SerialUID = 5L;
    private IServicios model;
    private transient GUIAgregarJugador gui;
    
    @Override
    public void ActualizarJugador()throws RemoteException {
        gui.ActualizarJugador();
    }
    
    public ViewAgregarJugador(IServicios s) throws RemoteException{
        this.model = s;
        gui = new GUIAgregarJugador(s);
        model.agregarHijos(this);
        gui.setVisible(true);
    }
    
}
