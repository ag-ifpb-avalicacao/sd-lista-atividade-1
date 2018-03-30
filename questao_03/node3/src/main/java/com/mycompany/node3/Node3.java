/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.node3;

import protocolo.Menssagem;
import protocolo.Protocolo;

/**
 *
 * @author alann
 */
public class Node3 {

    public static void main(String[] args) {

        System.out.println("Node3 iniciado...");
        Protocolo protocolo = new Protocolo(4041, 5051);
        Menssagem requisicao = protocolo.getRequest();
        System.out.println("Passou pelo node3");

        if (requisicao.getOperacao() == 2) {

            protocolo.setPortaRequisicao(4042);
            protocolo.setPortaResposta(5052);
            Menssagem resposta = protocolo.doOperation("127.0.0.1", requisicao);
            protocolo.setPortaResposta(5051);
            protocolo.sendReply(requisicao.getRemetente(), resposta);

        } else if (requisicao.getOperacao() == 1) {

            protocolo.setPortaRequisicao(4040);
            protocolo.setPortaResposta(5050);
            Menssagem resposta = protocolo.doOperation("127.0.0.1", requisicao);
            protocolo.setPortaResposta(5051);
            protocolo.sendReply(requisicao.getRemetente(), resposta);
        }
    }

}
