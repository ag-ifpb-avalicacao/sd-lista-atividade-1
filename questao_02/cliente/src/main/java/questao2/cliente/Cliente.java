/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2.cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import remotos.Remoto;

/**
 *
 * @author juan
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            Remoto contract = (Remoto) LocateRegistry.getRegistry("no1", 1099).lookup("rmi:/no1");
            int result = contract.operacao2(2, 4);
            System.out.println("TETANDO RESULTADO");
            System.out.println(result);
        } catch (NotBoundException | RemoteException ex) {
        }
    }
}
