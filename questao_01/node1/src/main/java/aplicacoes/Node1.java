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
public class Node1 {

    public static void main(String[] args) throws UnknownHostException,
            SocketException, IOException {

        /*
        instancia de um protocolo para enviar e receber menssagens entre 
        processos passando as portas para enviar e receber.
        */
        Protocolo protocolo = new Protocolo(4040, 5050);

        //criando valores aleatorios entre 0 e 100
        Random random = new Random();
        int x = random.nextInt(101);
        int y = random.nextInt(101);
        
        //int x = 2;
        //int y = 2;

        // criando buffer de bytes com os argumentos da requisicao
        int tamanho = Integer.BYTES * 2;
        ByteBuffer bff = ByteBuffer.allocate(tamanho);
        
        //jogando em um buffer de bytes para criação da menssagem
        bff.putInt(x);
        bff.putInt(y);
        
        //montando uma requisicao
        Menssagem requisicao = new Menssagem(1, bff.array());

        // menssagem de resposta apos enviar uma requisicoa para o servidor
        Menssagem resposta = protocolo.doOperation("localhost", requisicao);

        //montando a resposta em uma string
        String texto = new String(resposta.getArgs());

        System.out.println(texto);

    }

}
