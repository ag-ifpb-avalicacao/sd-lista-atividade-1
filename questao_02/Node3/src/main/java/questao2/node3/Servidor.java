/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2.node3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author alann
 */
public class Servidor {
    public static void main(String[] args) throws NotBoundException {
        try {
            Registry reg = LocateRegistry.createRegistry(1097);
            reg.rebind("rmi:/no3", new RemotoImpl());
        } catch (RemoteException ex) {
            System.out.println("Erro de acesso remoto");
        }
    }
    
}