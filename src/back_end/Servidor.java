package back_end;
import java.io.*;
import java.net.*;
import java.util.*;


public class Servidor {
	 static ServerSocket serverSocket = null;
	 private static List<Jogador> listJogador;
	 private int dado = 0;
	 
	
	public static void main() throws IOException {
		 
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
			 j.start();
			 listJogador.add(j);
			 
			 
			 if(listJogador.size() < 4) {
				 serverSocket.setSoTimeout(10000);
			 }else if(listJogador.size() == 4) {
				 //comeca o jogo
				 //
				 
			 }
				
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
	    
}
