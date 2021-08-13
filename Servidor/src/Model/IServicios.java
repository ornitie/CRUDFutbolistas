/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import View.IVentanas;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IServicios extends Remote{
    
    void agregarHijos(IVentanas hijo) throws RemoteException;
    void insertar(Futbolista f) throws RemoteException;
    void actualizar(Futbolista f)throws RemoteException;
    void eliminar(String id)throws RemoteException;
    Futbolista buscar(String id)throws RemoteException;
    List<Futbolista> listar()throws RemoteException;
    
}
