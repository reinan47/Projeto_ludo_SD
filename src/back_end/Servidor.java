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
        
        
     try {   
        while(listJogador.size() < 4) {
            //PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            //BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

             Jogador j = new Jogador(serverSocket.accept());
             listJogador.add(j);
             //criar metodo ao inves de thread
             //j.start();
             
             if(listJogador.size() == 2) {
            	 serverSocket.setSoTimeout(5000);
             }
             

        }
     }catch(SocketTimeoutException e) {
    	 
     }
        
       //logica do jogo 
	 int i = 0;
	//dedicando as pecas ao jogadores
	 for(Jogador jogador : listJogador) {
		 jogador.setPeca(armazena[i]); 
		 i++;
	 }
    
     i = 0;
     Jogador jogadorDaVez = listJogador.get(0);// variavel para armazena o jogador que vai fazer a jogada no round
     /*
     while(!seacabouojogo) {
         pedirValorDoDado(jogadorDaVez) 
         while(jogada) {
         
             // o servidor uma requisicao pedindo a jogada do jogadorDaVez
             //o servidor recebe a jogada 
             if(jogou o dado == 6) {
                //se a jogada tiver valida, 
                //vai mandar um broadcast com a posicao de todas as pecas
                 variavel jogada server para o jogador continuar jogando
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
    
    public int pedirValorDoDado(Jogador j) throws IOException {
    	  Socket socket = j.getSocket();
    	  int valorDoDado = 0;
    	  try {
    		  //escrevendo no arquivo
    		  String valor = "1";
    		  File file = new File("arquivo_enviado_cliente.txt");
    	      file.createNewFile();
    	      FileWriter fileWriter = new FileWriter(file);
    	      BufferedWriter escrever = new BufferedWriter(fileWriter);   
    	      escrever.write(valor);
    	      
    	      escrever.close();
    	      fileWriter.close();
    	      //enviando o arquivo ao cliente
    	      OutputStream outputStream = socket.getOutputStream();
            
              byte[] buffer = new byte[(int) file.length()];
              FileInputStream fileInputStream = new FileInputStream(file);
              BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
              bufferedInputStream.read(buffer, 0, buffer.length);
              outputStream.write(buffer, 0, buffer.length);
              outputStream.flush();
              socket.shutdownOutput();
              
              //recebendo a resposta do cliente
              InputStream inputStream = socket.getInputStream();
              FileOutputStream fileOutputStream = new FileOutputStream("arquivo_recebido.txt");
              byte[] bufferRecebimento = new byte[1024];
              int length;
              while ((length = inputStream.read(bufferRecebimento)) > 0) {
                  fileOutputStream.write(bufferRecebimento, 0, length);
              }
              //lendo o arquivo que receber do cliente e transformando para int
              FileReader arq = new FileReader("arquivo_recebido.txt");
              BufferedReader ler = new BufferedReader(arq);
              String linha = "";
            
              int i = 0;
              linha = ler.readLine();
              valorDoDado = Integer.parseInt(linha); 
              
              arq.close();
              fileOutputStream.close();
              inputStream.close();
              
              
              bufferedInputStream.close();
              fileInputStream.close();
              socket.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
    	  
    	  return valorDoDado;
    }

}