package back_end;
import java.io.*;
import java.net.*;
import java.util.*;

import front_end.pecas;

public class Jogador extends Thread  {
    private Socket socket;
    private pecas peca;
    private int dado;

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
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader lendo = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine, outputLine;
            while ((inputLine = lendo.readLine()) != null) {
                outputLine = "Resposta: " + inputLine;
                saida.println(outputLine);
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



}