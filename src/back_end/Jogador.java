package back_end;

import java.net.Socket;

import front_end.pecas;

public class Jogador extends Thread  {
	private String nomeJogador;
	private pecas peca;
	private Socket socket;
	
	public Jogador (Socket socket) {
		super();
		this.setSocket(socket);
	}
	
	public void run() {
		
	}
	
	//metodos getters e setters
	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public pecas getNomePeca() {
		return peca;
	}
	public void setNomePeca(pecas nomePeca) {
		this.peca = nomePeca;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	
	
}
