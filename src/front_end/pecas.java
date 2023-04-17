package front_end;

import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class pecas extends Thread{
	private JLabel peca;
	private int numDado;
	private String nomeImg;
	private int numPlay;
	private String nomePlay;
	private ImageIcon img;
	
	private int posX;
	private int posY;
	
	
	public pecas(JLabel peca/*, int numDado, String nomeImg, int numPlay, String nomePlay*/) {
		super();
		this.peca = peca;
		this.numDado = numDado;
		this.nomeImg = nomeImg;
		this.numPlay = numPlay;
		this.nomePlay = nomePlay;
	}

	public void run() {
		jogada(numDado, peca);
	}
	
	public void jogada(int numDado, JLabel peca) {
		posX = peca.getX();
		posY = peca.getY();
		
		for(int i = 0 ; i < 500 ; i++) {
			sleep();
			if(i%2 == 0) {
				img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"));
			}else {
				img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente2.png"));
			}
			peca.setIcon(img);
			posY += 10;
			posX -= 10;
			peca.setLocation(posX + i, posY + i);
		}
	}
	public void sleep() {
		try {
			TimeUnit.MILLISECONDS.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
