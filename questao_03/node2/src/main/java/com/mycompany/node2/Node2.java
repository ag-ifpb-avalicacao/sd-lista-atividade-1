/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.node2;

import protocolo.Menssagem;
import protocolo.Protocolo;

/**
 *
 * @author alann
 */
public class Node2 {

    public static void main(String[] args) {

        System.out.println("Node2 iniciado...");
        Protocolo protocolo = new Protocolo(4040, 5050);
        Menssagem requisicao = protocolo.getRequest();
        System.out.println("Passou pelo node2");

        if (requisicao.getOperacao() == 2) {

            protocolo.setPortaRequisicao(4041);
            protocolo.setPortaResposta(5051);
            Menssagem resposta = protocolo.doOperation("127.0.0.1", requisicao);
            protocolo.setPortaResposta(5050);
            protocolo.sendReply(requisicao.getRemetente(), resposta);

        } else if (requisicao.getOperacao() == 1) {

            protocolo.setPortaRequisicao(4042);
            protocolo.setPortaResposta(5052);
            Menssagem resposta = protocolo.doOperation("127.0.0.1", requisicao);
            protocolo.setPortaResposta(5050);
            protocolo.sendReply(requisicao.getRemetente(), resposta);
        }

    }
}
