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
	private int qtdPercurso = 0;
	private int qtdPeca = 4;
	private JLabel p[];
	private String enderecoNet;
	private int port;
	private OutputStream outputStream;
	private InputStream inputStream;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
	public Jogador(Socket socket) {
		//super();
		this.setSocket(socket);
	}
	
	public Jogador(pecas p, int dado) {
		this.peca = p;
		this.dado = dado;
	}

	
	public void run()  {
		
	
		String requisicao =" ";
		try {
		while(true)
		{
		    int bytesLidos = 0;
			try {
				inputStream = socket.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        byte[] buffer = new byte[1024];
			try {
				bytesLidos = inputStream.read(buffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        requisicao = new String(buffer, 0, bytesLidos);
	        System.out.println("Servidor diz: " +requisicao);
	        
	        if(requisicao == "1") {
	        	//faz a jogada e escrever em um arquivo
	        	//sorteia o dado
	        	//chama a funcao jogada
	        	
	        	//enviando o arquivo de jogada para o servidor
				try {
					outputStream = socket.getOutputStream();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                //criando arquivo
				try {
					fileInputStream = new FileInputStream("arquivo_cliente_jogada.txt");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					try {
						while ((bytesLidos = fileInputStream.read(buffer)) != -1) {	
								outputStream.write(buffer, 0, bytesLidos);
							
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
	        	
	        }else if(requisicao == "2") {
	        	//atualizar tela
	        	//mandar uma requisicao e depois um arquivo no servidor
				try {
					fileOutputStream = new FileOutputStream("arquivo_recebido.txt");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					while ((bytesLidos = inputStream.read(buffer)) != -1) {
						fileOutputStream.write(buffer, 0, bytesLidos);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileReader arq = new FileReader("arquivo_recebido.txt");
				//vai ter os valores que vai ser passado pra funcao
				String[] valores = new String[4];
				String[] receber = new String[4];
				BufferedReader ler = new BufferedReader(arq);
	            //ler o arquivo e colocar dentro de um variaveis o vetor
				
	            String linha = ler.readLine();
	           
	                
	            String conteudo[] = linha.split(";");
	            valores[0] = conteudo[0];
                valores[1] = conteudo[1];
                valores[2] = conteudo[2];
                valores[3] = conteudo[3];
                valores[4] = conteudo[4];
                
                arq.close();

	             
	         
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	        }
			
	       
		}
		}catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//se for 1
		
				//ativa o botao do dado
				//atualiza a mensagem para visar o cara jogar
				
		// se for 2
				//receber os dados enviado pelo servidor contendo a atualizacao da jogada do oponente
		
		 
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("foi");
		try {
			socket = new Socket("127.0.0.1", 8000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public int getQtdPercurso() {
		return qtdPercurso;
	}

	public void setQtdPercurso(int qtdPercurso) {
		this.qtdPercurso += qtdPercurso;
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