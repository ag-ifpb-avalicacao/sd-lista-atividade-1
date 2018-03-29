/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2.node3;

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
        try {
            Remoto contract = (Remoto) LocateRegistry.getRegistry("no1", 1099).lookup("rmi:/no1");
            return contract.operacao1(x, y);
        } catch (NotBoundException ex) {
            System.out.println("Erro de acesso remoto");
        }
        try {
            Remoto contract = (Remoto) LocateRegistry.getRegistry("no2", 1099).lookup("rmi:/no2");
            return contract.operacao1(x, y);
        } catch (NotBoundException ex) {
            System.out.println("Erro de acesso remoto");
        }
        throw new RemoteException();
    }

    @Override
    public int operacao2(int x, int y) throws RemoteException {
        int resultado = (2 * x) / y;
        return resultado;
    }

}
