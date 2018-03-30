/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.node4;

import java.nio.ByteBuffer;
import protocolo.Menssagem;
import protocolo.Protocolo;

/**
 *
 * @author alann
 */
public class Node4 {

    public static void main(String[] args){

            System.out.println("Node4 iniciado...");
            Protocolo protocolo = new Protocolo(4042, 5052);
            Menssagem requisicao = protocolo.getRequest();
            System.out.println("Node4 pegou a requisicao");

            Menssagem resposta = executar(requisicao);

            protocolo.sendReply(requisicao.getRemetente(), resposta);
            System.out.println("Resolvido no node4");
        
    }

    private static Menssagem executar(Menssagem requisicao) {
        
        int resultado = 0;
        
        ByteBuffer bff = ByteBuffer.wrap(requisicao.getArgs());
        int x = bff.getInt();
        int y = bff.getInt();

        if (requisicao.getOperacao() == 2) resultado = x - y;
        else if (requisicao.getOperacao() == 1) resultado = x + y;
         
        String msgResposta = "O resultado de sua operação é = " + resultado;
        Menssagem resposta = new Menssagem(0, msgResposta.getBytes());

        return resposta;
    }

}
