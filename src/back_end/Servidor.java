package back_end;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor extends Thread {
	static ServerSocket serverSocket = null;
	private static List<Socket> listJogador = new ArrayList<>();
	private static int port = 8000;
	public static Socket s;
	public static Jogador j;
	public static Jogador j2;

	public static void main(String[] args) {
		try {
			ServidorJogada();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     //vai receber parametros o ip e a pors
	public static void ServidorJogada() throws IOException {

		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println("Não foi possível escutar na porta 8000.");
			System.exit(-1);
		}
		// criando as pecas
		// criando variavel para armazena no vetor e atribuir os jogadores

		try {

			while (listJogador.size() < 4) {
			// PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
			// BufferedReader in = new BufferedReader(new
			// InputStreamReader(serverSocket.getInputStream()));
			//PASSANDO OS PARAMETROS VINDO PANEL IP E A PORTA
			Socket sj = new Socket("127.0.0.1", 8000);
			j = new Jogador(sj);
			j.start();
			s = serverSocket.accept();
			listJogador.add(s);
			/*Socket sj2 = new Socket("127.0.0.1", 8000);
			j2 = new Jogador(sj2);
			j2.start();
			s = serverSocket.accept();
			listJogador.add(s);*/
			
			}
			//System.out.println("Entrou");
//			listJogador.add(j);
//			System.out.println(listJogador.get(0).getSocket().getPort());
			// criar metodo ao inves de thread
			// j.start();

			/*
			 * if (listJogador.size() == 2) { serverSocket.setSoTimeout(50000); }
			 */

//			}
		} catch (SocketTimeoutException e) {

		}

		// logica do jogo
		int i = 0;
		// dedicando as pecas ao jogadores
//		for (Jogador jogador : listJogador) {
//			// jogador.setPeca(armazena[i]);
//			i++;
//		}
		
		i = 0;
//		Jogador jogadorDaVez = listJogador.get(0);// variavel para armazena o jogador que vai fazer a jogada no round
		// int valorDoDado;
		boolean jogada = true;
		String[] qtdPecas = EnviarPecas(listJogador);
		while (AcabouOJogo(qtdPecas) == false) {
			while (jogada) {
				String jogadaDoJogador = "";
				System.out.println("==== funcao vez do jogador ====");
				jogadaDoJogador = RequisicaoAoJogador(j, listJogador.get(1));
				String valores[] = jogadaDoJogador.split(";");
				System.out.println("==== Enviar para todos ====");
				EnviarParaTodos(listJogador, jogadaDoJogador);
				// qtdPecas = EnviarPecas(listJogador);

				System.out.println("Valores passado no X do jogador 1: " + j.getX());
				System.out.println("Valores passado no X do jogador 2: " + j2.getX());

				if (valores[0] != "6") {// SE O VALOR DO DADO FOR DIFERENTE DE 6 MUDA DE JOGADOR, SE NAO CONTINUA O
										// MESMO JOGADOR
					jogada = false;
					i++;

				} else {
					jogada = true;
				}
				// no caso do incremento passar de 4, ja que só possuem 4 jogadores.

				// }
				// enivar broadcast com as informacoes de todos o jogadores
				if (i > 4) {
					i = 0;
				}
			}
		}
		// mudar o jogador para jogar naquele round
//		jogadorDaVez = listJogador.get(i);
	}

	// }

	public static boolean AcabouOJogo(String[] pecas) {
		for (String s : pecas) {
			if(Integer.parseInt(s) == 0) {
				return true;
			}
		}
		return false;
	}
	
    //AVISANDO AO JOGADOR QUE E A VEZ DELE
	public static String RequisicaoAoJogador(Jogador j, Socket s) throws IOException {
		String requisicao = "1";
		String jogada = "";
	
		try {
			//
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
			OutputStream out = s.getOutputStream();

			// enviando requisicao para cliente
			PrintWriter pw = new PrintWriter(out, true); // o segundo parametro "true" é para habilitar a autoflush do buffer
			pw.println(requisicao);
			
			
			// recebendo a jogada do cliente
			//System.out.println("from jogador: " + inFromClient.readLine());
            jogada = inFromClient.readLine();
          //FECHA O SOCKET
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jogada;

		
	}
    //ENVIAR JOGADA PARA TODOS
	public static void EnviarParaTodos(List<Socket> listJogador, String jogada) throws IOException {
		int i = 0;
		for (Socket j : listJogador) {
			OutputStream out = j.getOutputStream();

			// enviando requisicao para cliente
			PrintWriter pw = new PrintWriter(out, true); // o segundo parametro "true" é para habilitar a autoflush do
															// buffer
			
			String requisicao = "2";
			// enviando a requisicao
			pw.println(requisicao);
			// enviando jogada para o cliente
			pw.println(jogada);
			i++;
		}
		//FECHA O SOCKET
		
	}
	//QUANTIDADE DE PECA QUE CADA JOGADOR TEM
	public static String[] EnviarPecas(List<Socket> listJogador) {
		String[] pecas = null;
		int i=0;
		try {
		for (Socket j : listJogador) {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(j.getInputStream()));
			OutputStream out = j.getOutputStream();

			// enviando requisicao para cliente
			PrintWriter pw = new PrintWriter(out, true); 
			String requisicao = "3";
			// enviando a requisicao
			pw.println(requisicao);
			// quantidade de peca
			pecas[i] = inFromClient.readLine();
			i++;
		}
		}catch (IOException e) {
			e.printStackTrace();
		}
		//FECHA O SOCKET
		return pecas;
		
	}
	
}