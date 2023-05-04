package back_end;
import java.io.*;
import java.net.*;
import java.util.*;

import front_end.pecas;


public class Servidor {
     static ServerSocket serverSocket = null;
     private static List<Jogador> listJogador = new ArrayList<>();
     private static int port = 8000;

     public static void main(String[] args) {
 		try {
 			ServidorJogada();
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}

    public static void ServidorJogada() throws IOException {

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Não foi possível escutar na porta 8000.");
            System.exit(-1);
        }
        //criando as pecas
        pecas kankuro = new pecas("kankuro", 0, 0);
        pecas sasuke = new pecas("sasuke", 0, 0);
        pecas gaara = new pecas("gaara", 0, 0);
        pecas choji = new pecas("choji", 0, 0);
        kankuro.start();
        sasuke.start();
        gaara.start();
        choji.start();
        //criando variavel para armazena no vetor e atribuir os jogadores
        pecas[] armazena = {kankuro, sasuke, gaara, choji};
        
        
     try {  
    	
        while(listJogador.size() < 4) {
            //PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            //BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

        	
             Jogador j = new Jogador( serverSocket.accept());
             
             System.out.println("Entrou");
             listJogador.add(j);
             //criar metodo ao inves de thread
             //j.start();
             
             if(listJogador.size() == 2) {
            	 serverSocket.setSoTimeout(50000);
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
     int valorDoDado;
     while(AcabouOJogo(listJogador) == false) {
         valorDoDado = PedirValorDoDado(jogadorDaVez);
         boolean jogada = true;
         while(jogada == true) {
        	 int contValorSeis = 0;
             // o servidor uma requisicao pedindo a jogada do jogadorDaVez
             //o servidor recebe a jogada 
             if(valorDoDado == 6) {
            	 contValorSeis++;
                //se a jogada tiver valida, 
                //vai mandar um broadcast com a posicao de todas as pecas
            	 if(contValorSeis == 3) {
            		 jogada = false;
            	 }else {
            		 jogadorDaVez.setQtdPercurso(valorDoDado);
            		 if(jogadorDaVez.getQtdPercurso() == 57 && jogadorDaVez.getQtdPeca() > 0) {//QUANDO UMA PECA CHEGAR AO PERCURSO MAXIMO QUE E 57
            			 jogadorDaVez.setQtdPeca();
            		 }
            		 //verificarAtaque
            		 
                     jogada = true;
            	 }
            	
                 
             }else if(valorDoDado != 6){
            	 jogadorDaVez.setQtdPercurso(valorDoDado);
            	 if(jogadorDaVez.getQtdPercurso() == 57 && jogadorDaVez.getQtdPeca() > 0) {//QUANDO UMA PECA CHEGAR AO PERCURSO MAXIMO QUE E 57
        			 jogadorDaVez.setQtdPeca();
        		 }
            	 //verificarAtaque
            	 jogada = false;
                     
             }
         }
         //enivar broadcast com as informacoes de todos o jogadores
         i++;
         // no caso do incremento passar de 4, ja que só possuem 4 jogadores.
         if(i > 4) { 
        	 i = 0;
         }
       //mudar o jogador para jogar naquele round
         jogadorDaVez = listJogador.get(i); 
     }
     

    }
    
    public static boolean AcabouOJogo(List<Jogador> listJogador) {
    	 for(Jogador jogador : listJogador) {
    		if(jogador.getQtdPeca() == 0) {
    			return true;
    		}
    	 }
    	 return false;
    }
    
    public static boolean Ataque(List<Jogador> listJogador, Jogador jogadorDaVez) {
		for (Jogador jogador : listJogador) {
			if (!jogadorDaVez.equals(jogador))//para nao pegar o mesmo jogador que esta na lista
				if (jogador.getPeca().getPosX() == jogadorDaVez.getPeca().getPosX()
						&& jogador.getPeca().getPosY() == jogadorDaVez.getPeca().getPosY()) {
					return true;
				}
		}
		return false;
    }
    
    public static int PedirValorDoDado(Jogador j) throws IOException {
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
              
              j.enviandoValorDoDado();
              //recebendo a resposta do cliente
              InputStream inputStream = j.getInputStream();
              FileOutputStream fileOutputStream = new FileOutputStream("arquivo_recebido_jogada.txt");
              byte[] bufferRecebimento = new byte[1024];
              int length;
              while ((length = inputStream.read(bufferRecebimento)) > 0) {
                  fileOutputStream.write(bufferRecebimento, 0, length);
              }
              //lendo o arquivo que receber do cliente e transformando para int
              FileReader arq = new FileReader("arquivo_recebido_jogada.txt");
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
    //ENVIAR INFORMACAOES PARA TODOS OS JOGADORES ATUALIZAREM A TELA
   /* public static void EnviarBroadCast(List<Jogador> listJogador) {
    	 DatagramSocket servidor = new DatagramSocket(5000);
    	 

    	 int numBytesLidos;
    	 int contJogador = 0;
    	 //escrevendo no arquivo
		  String valor = "1";
		  File file = new File("arquivo_enviado_cliente.txt");
	      file.createNewFile();
	      FileWriter fileWriter = new FileWriter(file);
	      BufferedWriter escrever = new BufferedWriter(fileWriter);   
	      escrever.write(valor);
	      
	      escrever.close();
	      fileWriter.close();
	     byte[] bufferArquivo = new byte[1024];

         while ((numBytesLidos = file.read(bufferArquivo)) > 0) {
             // Cria um pacote para enviar os dados do arquivo
             DatagramPacket pacoteArquivo = new DatagramPacket(bufferArquivo, numBytesLidos);
             OutputStream saida = listJogador.get(contJogador).getOutputStream();
             // Envia o pacote para todos os clientes conectados
             for (InetSocketAddress Jogador : ) {
                 pacoteArquivo.setSocketAddress(cliente);
                 servidor.send(pacoteArquivo);
             }
             contJogador++;
         }
    }*/

}