/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacoes;

import java.nio.ByteBuffer;
import protocolo.Menssagem;
import protocolo.Protocolo;

/**
 *
 * @author alann
 */
public class Node2 {

    public static void main(String[] args) {

        /*
        instancia de um protocolo para enviar e receber menssagens entre 
        processos passando as portas para enviar e receber.
         */
        Protocolo protocolo = new Protocolo(4040, 5050);

        // recebendo requisicao de um cliente
        Menssagem requisicao = protocolo.getRequest();

        // pegando os argumentos de uma requisicao e jogando em um buffer de bytes
        ByteBuffer bff = ByteBuffer.wrap(requisicao.getArgs());
        int x = bff.getInt();
        int y = bff.getInt();

        // caso os numeros forem iguais o node2 respode o node1
        if (x == y) {

            String msgResposta = "O resultado de sua operação é = 0";

            Menssagem resposta = new Menssagem(0, msgResposta.getBytes());

            protocolo.sendReply(requisicao.getRemetente(), resposta);

            System.out.println("Operação realizada pelo node2");

        /* caso os numeros nao forem iguais o node2 pede ao node3 para fazer a
           operacao, o node2 pega a resposta e envia para o node1. 
        */
        } else {

            //trocando portas do protocolo para acesso com o node3
            protocolo.setPortaRequisicao(4041);
            protocolo.setPortaResposta(5051);

            //menssagem de resposta recebida pelo node3
            Menssagem msg = protocolo.doOperation("localhost", requisicao);

            //trocando portas do protocolo para enviar resposta para o node1
            protocolo.setPortaResposta(5050);
            
            //eviando resposta para o node1
            protocolo.sendReply(requisicao.getRemetente(), msg);
        }

    }

}
