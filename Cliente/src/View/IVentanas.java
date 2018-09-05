/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Personal
 */
public interface IVentanas extends Remote{
    
     void ActualizarJugador() throws RemoteException;
}
