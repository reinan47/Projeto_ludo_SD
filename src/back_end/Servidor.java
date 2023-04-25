package back_end;
import java.io.*;
import java.net.*;
import java.util.*;

import front_end.pecas;


public class Servidor {
     static ServerSocket serverSocket = null;
     private static List<Jogador> listJogador;


    public static void ServidorJogada(pecas peca[]) throws IOException {

        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            System.err.println("Não foi possível escutar na porta 8000.");
            System.exit(-1);
        }

        while(true) {
            //PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            //BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

             Jogador j = new Jogador(serverSocket.accept());
             listJogador.add(j);
             j.start();

             if(listJogador.size() < 4) {
                 serverSocket.setSoTimeout(10000);
             }else if(listJogador.size() == 4) {
                 //comeca o jogo
                 //chama peca aqui, e atribuir peca ao jogador 
                 /*jogada = index
                 while(!seacabouojogo) {
                     while(jogada) {
                         regradojogo
                         if(jogou o dado == 6) {

                         }else if()que a vez dele acabou {
                             jogada = 0
                         }
                     }
                     list[++1]; //colocar o proximo jogo
                 }*/

             }

        }

    }

}