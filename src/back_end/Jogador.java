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
	private JLabel[] kankuro = new JLabel[57];
	private JLabel[] sasuke = new JLabel[57];
	private JLabel[] gaara = new JLabel[57];
	private JLabel[] choji = new JLabel[57];;
	
	private int x;
	private int y;
	
	
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
			String[] recebe = requisicao.split(";");
	        
	        System.out.println("Servidor diz: " +requisicao);
	       
	        
	        if(recebe[0].equals("1")) {
				// ATIVAR O BOTAO DE SORTEIO
                System.out.println("aki");
                //aki chama função que recebe o primeira jogada
                
	        	String jogadaDoJogador = p.jogadaInfo(5, 1, 0, 480, 82);
	        	jogadaDoJogador = jogadaDoJogador + ";" + recebe[1]; //recebe é o numero do  jogador na ordem da lista do socket
	        	System.out.println(jogadaDoJogador);
	        	//verificar a quantidade de peça
	        	PrintWriter pw = new PrintWriter(out, true); // o segundo parametro "true" é para habilitar a autoflush do buffer
				pw.println(jogadaDoJogador);

	        }else if(recebe[0].equals("2")) {
	        	//atualizar tela
	        	//mandar uma requisicao e depois um arquivo no servidor
	            //JOGADOR RECEBE JOGADA DO SERVIDOR
	        	String jogadas = "";
	        	
	        	jogadas = inB.readLine();
	        	//
	        	
	        	
	        	System.out.println("jogadas: " + jogadas);
	            String[] output = jogadas.split(";");//SEPARANDO OS PARAMETROS POR ;
	            int i = 0;
	            System.out.println(output.length);
	            /*for(String s : output) {
	            	System.out.println(s + " " + i);
	                i++;
	            }*/
	            
	            //Funcao para atualizar a tela
	            //A FUNCAO DE CHAMADA PARA ATUALIZAR A TELA DO JOGADOR
	            //defineJogador("5","1","5","480","82", "1"); 
	                                                         //O GET X E Y NAO SE ATUALIZAR ?
	            defineJogador(output[0], output[1], output[2], "513" , "280", "0");
	            System.out.println(output[0]);
	            //this.setX(Integer.parseInt(output[0]));
	            //chamar a funcao para atualizar a tela
	            
	        //jogador enviar quantas pecas tem
	        }else if(recebe[0].equals("3")) {
	        	PrintWriter pw = new PrintWriter(out, true); 
				pw.println(this.qtdPeca);
				pw.flush();
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
	

    //EM NEW PECAS EM VEZ DE PASSAR UM JLABEL DE PECA, TA PASSANDO UM INTEIRO
	public void defineJogador(String numDado, String numPlay, String percurso, String getX, String getY, String indexPeca) {
		if(numPlay.equals("0")) {
			new pecas(Integer.parseInt(numDado), Integer.parseInt(numPlay), Integer.parseInt(percurso),
					Integer.parseInt(getX),Integer.parseInt(getY),Integer.parseInt(indexPeca),"kankuro",kankuro).start();
		}
		else if(numPlay.equals("1")) {
			for(int i = 0; i < 57; i++) {
				sasuke[i] = new JLabel();//se tirar essa inicializacao aaqui, vai dar erro pq. os label vao ser null
			}    //linha 92 e 699 erros
			new pecas(Integer.parseInt(numDado), Integer.parseInt(numPlay), Integer.parseInt(percurso),
					Integer.parseInt(getX),Integer.parseInt(getY),Integer.parseInt(indexPeca),"sasuke",sasuke).start();
		}
		else if(numPlay.equals("2")) {
			new pecas(Integer.parseInt(numDado), Integer.parseInt(numPlay), Integer.parseInt(percurso),
					Integer.parseInt(getX),Integer.parseInt(getY),Integer.parseInt(indexPeca),"gaara",gaara).start();
		}
		else if(numPlay.equals("3")) {
			new pecas(Integer.parseInt(numDado), Integer.parseInt(numPlay), Integer.parseInt(percurso),
					Integer.parseInt(getX),Integer.parseInt(getY),Integer.parseInt(indexPeca),"choji",choji).start();
		}
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