package back_end;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JLabel;

import front_end.pecas;

public class Jogador extends Thread{
	private static Socket socket;
	private pecas peca;
	private int dado;
	private int qtdPeca = 4;
	private String enderecoNet;
	private int port;
	
	private OutputStream outputStream;
	private InputStream inputStream;
    //private FileInputStream fileInputStream;
    //private FileOutputStream fileOutputStream;
	private BufferedReader inFromUser;
	private DataOutputStream outToServer;
	private BufferedReader inFromServer;
	
	private JLabel[] kankuro;
	private JLabel[] sasuke;
	private JLabel[] gaara;
	private JLabel[] choji;
	
	private int getx;
	private int gety;
	
	private int portTeste;
	private String ip;
	
	public Jogador(int getx, int gety) {
		this.getx = getx;
		this.gety = gety;
	}
	
	private pecas p = new pecas();
	
	public Jogador(Socket socket) {
		//super();
		this.socket = socket;
	}
	
	
	public Jogador(pecas p, int dado) {
		this.peca = p;
		this.dado = dado;
	}
	public Jogador(JLabel[] kankuro, JLabel[] sasuke, JLabel[] gaara, JLabel[] choji) {
		this.kankuro = kankuro;
		this.sasuke = sasuke;
		this.gaara = gaara;
		this.choji = choji;
	}
	public Jogador(String ip, int port) {
		
	}
	public void run()  {
		String requisicao =" ";
		try {
		while(true)
		{
			
		    int bytesLidos = 0;
		    byte[] buffer = new byte[1024];
		    inFromUser = new BufferedReader(new InputStreamReader(
					System.in));
		    outToServer = new DataOutputStream(
					socket.getOutputStream());
			
		    InputStream inputStream = socket.getInputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            
            if(socket.isConnected()) {
            	System.out.println("ta conectado");
            	System.out.println(socket.getInetAddress());
            	System.out.println(socket.getPort());
            }System.out.println("antes de ler do servidor");
            
			requisicao = in.readLine();
			System.out.println("enviou");
			//inputStream = socket.getInputStream();
			
	        
			//bytesLidos = inputStream.read(buffer);
			
	       // requisicao = new String(buffer, 0, bytesLidos);
	        System.out.println("Servidor diz: " +requisicao);
	        buffer = new byte[1024];
	        
	        if(requisicao == "1") {
	        	//faz a jogada e escrever em um arquivo
				// ATIVAR O BOTAO DE SORTEIO
				// CHAMA AFUNCAO JOGADA,
                System.out.println("aki");
	        	String jogadaDoJogador;
	        	//A FUNCAO JOGADA RETORNAR UMA STRING
	        	//if(dado == 6 && percursoKankuro[0] == 0) {
	        		jogadaDoJogador = p.jogadaInfo(5, 0, 10, 300, 200, kankuro[0], "kankuro");
				//outputStream = socket.getOutputStream();//usado para mandar o arquivo via socket
	        	/*}else {
	        		
	        	}*/
                outToServer.writeBytes(jogadaDoJogador);

				// criando arquivo

				/*fileInputStream = new FileInputStream("arquivo_cliente_jogada.txt");

				while ((bytesLidos = fileInputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesLidos);

				}*/
					
			
	        	
	        }else if(requisicao == "2") {
	        	//atualizar tela
	        	//mandar uma requisicao e depois um arquivo no servidor
	        	//usado para ler o arquivo via socket
	        	String jogadas = "";
	        	
	        	jogadas = inFromServer.readLine();
	        	//bytesLidos = inputStream.read(buffer);
	        	//jogadas = new String(buffer, 0, bytesLidos);
	        		
	        	System.out.println("jogadas: " + jogadas);
	            String[] output = jogadas.split(";");//SEPARANDO OS PARAMETROS POR ;
	            System.out.println(output[0]);
	            //chamar a funcao para atualizar a tela
	            
	        	
				
				/*fileOutputStream = new FileOutputStream("arquivo_recebido.txt");

				while ((bytesLidos = inputStream.read(buffer)) != -1) {
					fileOutputStream.write(buffer, 0, bytesLidos);
				}

				FileReader arq = new FileReader("arquivo_recebido.txt");
				// vai ter os valores que vai ser passado pra funcao
				String[] valores = new String[4];
				String[] receber = new String[4];
				BufferedReader ler = new BufferedReader(arq);
				// ler o arquivo e colocar dentro de um variaveis o vetor

				String linha = ler.readLine();

				String conteudo[] = linha.split(";");
				valores[0] = conteudo[0];
				valores[1] = conteudo[1];
				valores[2] = conteudo[2];
				valores[3] = conteudo[3];
				valores[4] = conteudo[4];

				arq.close();
	             
	         
				
				fileOutputStream.close();*/
	            
	        }
			
	       
		}
		}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//se for 1
		
				//ativa o botao do dado
				//atualiza a mensagem para visar o cara jogar
				
		// se for 2
				//receber os dados enviado pelo servidor contendo a atualizacao da jogada do oponente
		
		 
		
		
	}
	public void defineJogador(int numPlay) {
		/*if(numPlay == 1) {
			new pecas(kankuro, 5, numPlay, "kankuro").start();
		}
		if(numPlay == 2) {
			new pecas(sasuke, 5, numPlay, "sasuke").start();
		}
		if(numPlay == 3) {
			new pecas(gaara, 5, numPlay, "gaara").start();
		}
		if(numPlay == 4) {
			new pecas(choji, 5, numPlay, "choji").start();
		}*/
	}
	

	
	public int numAleatorio() {
		Random gerador = new Random();
		return gerador.nextInt(6) + 1;
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public pecas getPeca() {
		return peca;
	}

	public void setPeca(pecas peca) {
		this.peca = peca;
	}

	public int getQtdPeca() {
		return qtdPeca;
	}

	public void setQtdPeca() {
		this.qtdPeca -= 1;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getEnderecoNet() {
		return enderecoNet;
	}

	public void setEnderecoNet(String enderecoNet) {
		this.enderecoNet = enderecoNet;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}