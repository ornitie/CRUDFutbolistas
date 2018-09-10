/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Juan Pablo
 */
public class Main {

    /**
     * Creates a new instance of Main
     */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//Direccion IP del equipo doonde se ejecute esta aplicacion Servidor
        String dbHost = "127.0.0.1";
        try {
            if (args.length > 0) {
                dbHost = args[0];
            }
            //puerto donde recide el servidor (model)
            LocateRegistry.createRegistry(1099);
            IServicios model = new ServicioFutbolista();
            Naming.rebind("//" + dbHost + "/CRUDFutbolistas", model);
            System.out.println("Objeto Model en el servidor...");
        } catch (Exception e) {
            System.out.println("Eror: " + e.getMessage());
        }
    }
}
