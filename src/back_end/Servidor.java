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
        //criando as pecas
        pecas kankuro = new pecas("kankuro", 0, 0);
        pecas sasuke = new pecas("sasuke", 0, 0);
        pecas gaara = new pecas("gaara", 0, 0);
        pecas choji = new pecas("choji", 0, 0);
        //criando variavel para armazena no vetor e atribuir os jogadores
        pecas[] armazena = {kankuro, sasuke, gaara, choji};
        
        
        
        while(true) {
            //PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            //BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

             Jogador j = new Jogador(serverSocket.accept());
             listJogador.add(j);
             j.start();
             

             if(listJogador.size() < 4) {
                 serverSocket.setSoTimeout(10000);
             }else if(listJogador.size() == 4) {
            	 int i = 0;
            	//dedicando as pecas ao jogadores
            	 for(Jogador jogador : listJogador) {
            		 jogador.setPeca(armazena[i]); 
            		 i++;
            	 }
                
                 i = 0;
                 Jogador jogadorDaVez = new Jogador(kankuro, 0);// variavel para armazena o jogador que vai fazer a jogada no round
                 /*
                 while(!seacabouojogo) {
                     while(jogada) {
                         
                         if(jogou o dado == 6) {
                            
                         }else if()que a vez dele acabou {
                             jogada = 0
                         }
                     }
                     i++;
                     // no caso do incremento passar de 4, ja que só possuem 4 jogadores.
                     if(i > 4) { 
                    	 i = 0;
                     }
                     jogadorDaVez = listJogador.get(i); //mudar o jogador para jogar naquele round
                 }
                 */

             }

        }

    }

}