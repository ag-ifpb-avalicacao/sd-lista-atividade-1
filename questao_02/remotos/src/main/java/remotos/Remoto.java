/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotos;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author alann
 */
public interface Remoto extends Remote {
    
    public int operacao1(int x, int y) throws RemoteException;
    public int operacao2(int x, int y) throws RemoteException;
    
}
