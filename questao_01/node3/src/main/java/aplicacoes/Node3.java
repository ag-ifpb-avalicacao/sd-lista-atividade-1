/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacoes;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Random;
import protocolo.Menssagem;
import protocolo.Protocolo;

/**
 *
 * @author alann
 */
public class Node3 {

    public static void main(String[] args) throws UnknownHostException,
            SocketException, IOException {

        /*
        instancia de um protocolo para enviar e receber menssagens entre 
        processos passando as portas para enviar e receber.
        */
        Protocolo protocolo = new Protocolo(4041, 5051);

        // recebendo requisicao de um cliente
        Menssagem requisicao = protocolo.getRequest();

        // pegando os argumentos de uma requisicao e jogando em um buffer de bytes
        ByteBuffer bff = ByteBuffer.wrap(requisicao.getArgs());
        int x = bff.getInt();
        int y = bff.getInt();
        
        //realizando conta da requisicao
        int resultado = (int) ((int) Math.pow(y, y) + Math.pow(x, x));
        
        //criando penssagem e devolvendo pra quem requisitou
        String msgResposta = "O resultado de sua operação é = " + resultado;

            Menssagem resposta = new Menssagem(0, msgResposta.getBytes());

            protocolo.sendReply(requisicao.getRemetente(), resposta);

            System.out.println("Operação realizada pelo node3");

    }

}
