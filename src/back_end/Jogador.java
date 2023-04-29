package back_end;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JLabel;

import front_end.pecas;

public class Jogador extends Thread {
	private Socket socket;
	private pecas peca;
	private int dado;
	private int qtdPercurso = 0;
	private int qtdPeca = 4;
	private JLabel p[];
	private String enderecoNet;

	public Jogador(Socket socket) {
		super();
		this.setSocket(socket);
	}

	public Jogador(pecas p, int dado) {
		this.peca = p;
		this.dado = dado;
	}

	public void enviandoValorDoDado() throws IOException {
		try {
			
			Socket socket = new Socket("localhost", this.socket.getPort());
            //lendo o arquivo e escutando
			InputStream inputStream = socket.getInputStream();
			FileOutputStream fileOutputStream = new FileOutputStream("arquivo_enviado_cliente.txt");
			byte[] buffer = new byte[1024];
			int length;
			while ((length = inputStream.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, length);
			}

			FileReader arq = new FileReader("arquivo_enviado_cliente.txt");
			BufferedReader ler = new BufferedReader(arq);
			String linha = "";

			int i = 0;
			linha = ler.readLine();
			int valor = Integer.parseInt(linha);

			arq.close();
			fileOutputStream.close();
			inputStream.close();
            // quer dizer que o jogador recebeu a requisicao e pode jogar
			if (valor == 1) {

				int numAleatorio = this.numAleatorio();
				File file = new File("arquivo_recebido.txt");
	    	    file.createNewFile();
	    	    FileWriter fileWriter = new FileWriter(file);
	    	    BufferedWriter escrever = new BufferedWriter(fileWriter);   
	    	    escrever.write(numAleatorio);
	    	      
	    	    escrever.close();
	    	    fileWriter.close();
	    	    byte[] bufferEnvio = new byte[(int) file.length()];

				// enviando o arquivo para o servidor

				FileInputStream lendo = new FileInputStream(file);
				OutputStream saida = this.socket.getOutputStream();
		        lendo.read(bufferEnvio, 0, bufferEnvio.length);
	            saida.write(bufferEnvio, 0, bufferEnvio.length);
	            saida.flush();
	            socket.shutdownOutput();
				saida.close();
				lendo.close();
			}

			
			socket.close();
		} catch (Exception e) {
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
		this.qtdPercurso = qtdPercurso;
	}

	public int getQtdPeca() {
		return qtdPeca;
	}

	public void setQtdPeca(int qtdPeca) {
		this.qtdPeca = qtdPeca;
	}

}