package back_end;

import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor extends Thread {
	static ServerSocket serverSocket = null;
	private static List<Jogador> listJogador = new ArrayList<>();
	private static int port = 8000;
	public static Socket s;
	public static Jogador j;

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
		// criando as pecas
		// criando variavel para armazena no vetor e atribuir os jogadores

		try {

//			while (listJogador.size() < 1) {
			// PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
			// BufferedReader in = new BufferedReader(new
			// InputStreamReader(serverSocket.getInputStream()));
			Socket sj = new Socket("127.0.0.1", 8000);
			j = new Jogador(sj);
			j.start();
			s = serverSocket.accept();

			System.out.println("Entrou");
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
		// while (AcabouOJogo(listJogador) == false) {
		// while (jogada) {
		String jogadaDoJogador = "";

		jogadaDoJogador = RequisicaoAoJogador(j, s);
		String valores[] = jogadaDoJogador.split(";");
		EnviarParaTodos(listJogador, jogadaDoJogador);

		/*
		 * while(jogada == true) { int contValorSeis = 0; // o servidor uma requisicao
		 * pedindo a jogada do jogadorDaVez //o servidor recebe a jogada if(valorDoDado
		 * == 6) { contValorSeis++; //se a jogada tiver valida, //vai mandar um
		 * broadcast com a posicao de todas as pecas if(contValorSeis == 3) { jogada =
		 * false; }else { jogadorDaVez.setQtdPercurso(valorDoDado);
		 * if(jogadorDaVez.getQtdPercurso() == 57 && jogadorDaVez.getQtdPeca() > 0)
		 * {//QUANDO UMA PECA CHEGAR AO PERCURSO MAXIMO QUE E 57
		 * jogadorDaVez.setQtdPeca(); } //verificarAtaque
		 * 
		 * jogada = true; }
		 * 
		 * 
		 * }else if(valorDoDado != 6){ jogadorDaVez.setQtdPercurso(valorDoDado);
		 * if(jogadorDaVez.getQtdPercurso() == 57 && jogadorDaVez.getQtdPeca() > 0)
		 * {//QUANDO UMA PECA CHEGAR AO PERCURSO MAXIMO QUE E 57
		 * jogadorDaVez.setQtdPeca(); } //verificarAtaque jogada = false;
		 * 
		 * } }
		 */
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
		// mudar o jogador para jogar naquele round
//		jogadorDaVez = listJogador.get(i);
	}

	// }

	public static boolean AcabouOJogo(List<Jogador> listJogador) {
		for (Jogador jogador : listJogador) {
			if (jogador.getQtdPeca() == 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean Ataque(List<Jogador> listJogador, Jogador jogadorDaVez) {
		for (Jogador jogador : listJogador) {
			if (!jogadorDaVez.equals(jogador))// para nao pegar o mesmo jogador que esta na lista
				if (jogador.getPeca().getPosX() == jogadorDaVez.getPeca().getPosX()
						&& jogador.getPeca().getPosY() == jogadorDaVez.getPeca().getPosY()) {
					return true;
				}
		}
		return false;
	}

	public static String RequisicaoAoJogador(Jogador j, Socket s) throws IOException {
		Socket socket = j.getSocket();
		String requisicao = "1";
		String jogada = "";
		byte[] cbuffer = new byte[1024];
		int bytesRead;
		try {
			//
			DataOutputStream outToClient = new DataOutputStream(s.getOutputStream());
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			System.out.println(s.getLocalPort());
			// enviando requisicao para cliente
			outToClient.writeInt(1);
			
			// recebendo a jogada do cliente
			System.out.println("from jogador: " + inFromClient.readLine());

			/*
			 * FileOutputStream fileOutputStream = new
			 * FileOutputStream("arquivo_jogada.txt"); byte[] buffer = new byte[1024]; int
			 * bytesLidos; while ((bytesLidos = inputStream.read(buffer)) != -1) {
			 * fileOutputStream.write(buffer, 0, bytesLidos); } fileOutputStream.close();
			 * 
			 * // Fecha o socket e o servidorSocket inputStream.close();
			 * outToClient.close();
			 */
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jogada;
	}

	public static void EnviarParaTodos(List<Jogador> listJogador, String jogada) throws IOException {
//		for (Jogador j : listJogador) {
		System.out.println("daniel ~e gpstossssssssssssssssssssssssso");
		Socket socket = j.getSocket();
		// OutputStream outputStream = socket.getOutputStream();
		System.out.println("daniel ~e gpstossssssssssssssssssssssssso");
		DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String requisicao = "2";
		// enviando a requisicao
		outToClient.writeBytes(requisicao);
		// enviando jogada para o cliente
		outToClient.writeBytes(jogada);

		// enviando arquivo
		/*
		 * FileInputStream fileInputStream = new FileInputStream("arquivo_jogada.txt");
		 * byte[] buffer = new byte[1024]; int bytesLidos; while ((bytesLidos =
		 * fileInputStream.read(buffer)) != -1) { outputStream.write(buffer, 0,
		 * bytesLidos); } fileInputStream.close(); outputStream.close();
		 */

//		}
	}
	// ENVIAR INFORMACAOES PARA TODOS OS JOGADORES ATUALIZAREM A TELA
	/*
	 * public static void EnviarBroadCast(List<Jogador> listJogador) {
	 * DatagramSocket servidor = new DatagramSocket(5000);
	 * 
	 * 
	 * int numBytesLidos; int contJogador = 0; //escrevendo no arquivo String valor
	 * = "1"; File file = new File("arquivo_enviado_cliente.txt");
	 * file.createNewFile(); FileWriter fileWriter = new FileWriter(file);
	 * BufferedWriter escrever = new BufferedWriter(fileWriter);
	 * escrever.write(valor);
	 * 
	 * escrever.close(); fileWriter.close(); byte[] bufferArquivo = new byte[1024];
	 * 
	 * while ((numBytesLidos = file.read(bufferArquivo)) > 0) { // Cria um pacote
	 * para enviar os dados do arquivo DatagramPacket pacoteArquivo = new
	 * DatagramPacket(bufferArquivo, numBytesLidos); OutputStream saida =
	 * listJogador.get(contJogador).getOutputStream(); // Envia o pacote para todos
	 * os clientes conectados for (InetSocketAddress Jogador : ) {
	 * pacoteArquivo.setSocketAddress(cliente); servidor.send(pacoteArquivo); }
	 * contJogador++; } }
	 */

}