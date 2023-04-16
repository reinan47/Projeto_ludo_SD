package front_end;

import javax.swing.JLabel;

public class pecas extends Thread{
	private JLabel peca;
	private int numDado;
	private String nomeImg;
	private int numPlay;
	private String nomePlay;
	
	
	
	public pecas(JLabel peca, int numDado, String nomeImg, int numPlay, String nomePlay) {
		super();
		this.peca = peca;
		this.numDado = numDado;
		this.nomeImg = nomeImg;
		this.numPlay = numPlay;
		this.nomePlay = nomePlay;
	}

	public void run() {
		
	}
	
	public void jogada(int numDado, JLabel peca) {
		
		
	}

}
