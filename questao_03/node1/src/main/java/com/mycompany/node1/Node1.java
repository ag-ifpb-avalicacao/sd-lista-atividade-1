/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.node1;

import java.nio.ByteBuffer;
import protocolo.Menssagem;
import protocolo.Protocolo;
/**
 *
 * @author alann
 */
public class Node1 {

    public static void main(String[] args){

        int x = 5;
        int y = 6;

        int operacao = 2;
        // int opercao = 1;
        
        int tamanho = Integer.BYTES * 2;

        ByteBuffer arg = ByteBuffer.allocate(tamanho);
        arg.putInt(x);
        arg.putInt(y);

        Menssagem requisicao = new Menssagem(operacao, arg.array());
        
        if (operacao == 1){
            
            Protocolo protocolo = new Protocolo(4041,5051);
            Menssagem resposta = protocolo.doOperation("127.0.0.1", requisicao);
            mostraResposta(resposta);
        }
        
        else if (operacao == 2){
            
            Protocolo protocolo = new Protocolo(4040,5050);
            Menssagem resposta = protocolo.doOperation("127.0.0.1", requisicao);
            mostraResposta(resposta);
        }
        
    }
    
    public static void mostraResposta(Menssagem resposta){
        String texto = new String(resposta.getArgs());
        System.out.println(texto);
    }

}
