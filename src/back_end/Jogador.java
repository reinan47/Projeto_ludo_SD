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
	
	private int x;
	private int y;
	
	private int portTeste;
	private String ip;
	/*
	public Jogador(int getx, int gety) {
		this.setGetx(getx);
		this.gety = gety;
	}*/
	
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
		
		    InputStream inputStream = socket.getInputStream();

            //DataInputStream in = new DataInputStream(inputStream);
            BufferedReader inB = new BufferedReader(new InputStreamReader(inputStream)); 
            
            OutputStream out = socket.getOutputStream();

            
            System.out.println("antes de ler do servidor");
            
           
			System.out.println("enviou");
			//inputStream = socket.getInputStream();
			requisicao = inB.readLine();
	        
	        System.out.println("Servidor diz: " +requisicao);
	       
	        
	        if(requisicao.equals("1")) {
	        	//faz a jogada e escrever em um arquivo
				// ATIVAR O BOTAO DE SORTEIO
                System.out.println("aki");
             // CHAMA AFUNCAO JOGADA,
	        	String jogadaDoJogador = "123;333";
	        	
	        	PrintWriter pw = new PrintWriter(out, true); // o segundo parametro "true" é para habilitar a autoflush do buffer
				pw.println(jogadaDoJogador);
			
					
			
	        	
	        }else if(requisicao.equals("2")) {
	        	//atualizar tela
	        	//mandar uma requisicao e depois um arquivo no servidor
	            //JOGADOR RECEBE JOGADA DO SERVIDOR
	        	String jogadas = "";
	        	
	        	jogadas = inB.readLine();
	        	
	        	System.out.println("jogadas: " + jogadas);
	            String[] output = jogadas.split(";");//SEPARANDO OS PARAMETROS POR ;
	            System.out.println(output[0]);
	            this.setX(Integer.parseInt(output[0]));
	            //chamar a funcao para atualizar a tela
	            
	    
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


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	
}