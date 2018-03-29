/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2.node1;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import remotos.Remoto;

/**
 *
 * @author alann
 */
public class RemotoImpl extends UnicastRemoteObject implements Remoto {
    
    public RemotoImpl() throws RemoteException {
        super();
    }

    @Override
    public int operacao1(int x, int y) throws RemoteException {

        int resultado = 2 * y * x;
        return resultado;
    }

    @Override
    public int operacao2(int x, int y) throws RemoteException, AccessException {

        try {
            
            Remoto remoto = (Remoto) LocateRegistry.getRegistry("no3", 1099).lookup("rmi:/no3");
            return remoto.operacao2(x, y);
            
        } catch (NotBoundException ex) {
            
            System.out.println("Erro de acesso remoto");
        }
        throw new RemoteException();
    }
}
