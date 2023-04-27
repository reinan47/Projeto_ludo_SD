package back_end;
import java.io.*;
import java.net.*;
import java.util.*;

import front_end.pecas;

public class Jogador extends Thread  {
    private Socket socket;
    private pecas peca;
    private int dado;
    private int qtdPercurso = 0;
    private int qtdPeca = 4;

    public Jogador (Socket socket) {
        super();
        this.setSocket(socket);
    }
    
    public Jogador(pecas p, int dado) {
    	this.peca = p;
    	this.dado = dado;
    }

    public void run() {
        try{
          
            int numAleatorio = this.numAleatorio();
            String caminho = "C:.\\Projeto_ludo_SD\\numAleatorio.txt";
            String conteudo = "" + numAleatorio; //transformando em string
            //criando o arquivo com numero aleatorio
            FileWriter escrever = new FileWriter(caminho);
            escrever.write(conteudo);
            escrever.close();
            
            
            //enviando o arquivo para o servidor
            File arquivo = new File(caminho);
            FileInputStream lendo = new FileInputStream(arquivo);
            OutputStream saida = this.socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            String inputLine, outputLine;
            while ((bytesRead = lendo.read(buffer)) != -1) {
            	saida.write(buffer, 0, bytesRead);
                //System.out.println("Recebido do cliente " + socket.getInetAddress().getHostName() + ": " + inputLine);
            }

            saida.close();
            lendo.close();
            socket.close();
        }catch(Exception e){
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