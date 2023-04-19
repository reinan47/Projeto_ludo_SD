package front_end;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class pecas extends Thread {
	private JLabel peca[];
	private int numDado;
	private String nomeImg;
	private int numPlay;
	private String nomePlay;
	private ImageIcon img;

	private int initialX;
	private int initialY;
	//casa inicial quando tirar um 6 no sorteio
	private int inicioKankuroX = 480;
	private int inicioKankuroY = 82;

	private int posX;
	private int posY;

	public pecas(JLabel peca[], int numDado/* , String nomeImg, int numPlay, String nomePlay */) {
		super();
		this.peca = peca;
		this.numDado = numDado;
		this.nomeImg = nomeImg;
		this.numPlay = numPlay;
		this.nomePlay = nomePlay;
	}

	public void run() {
		//new tocaTrilhaSonora().start();
		jogada(numDado, peca[0]);
	}

	public void jogada(int numDado, JLabel peca) {
		initialX = peca.getX();
		initialY = peca.getY();
		posX = peca.getX() - 88;
		posY = peca.getY() - 50;

		for (int i = 0; i < numDado; i++) {
			if (i % 2 == 0) {
				img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"));
			} else {
				img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente2.png"));
			}

			if (i <= 5) {
				posY += 33;
			}
			if (i >= 5 && i < 11) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita2.png"));
				}
				posX += 33;
			}
			if (i >= 11 && i < 13) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente2.png"));
				}
				posY += 33;
			}
			if (i >= 13 && i <= 18) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda2.png"));
				}
				posX -= 33;
			}
			if (i >= 18 && i < 24) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente2.png"));
				}
				posY += 33;
			}
			if (i >= 24 && i < 26) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda2.png"));
				}
				posX -= 33;
			}
			if (i >= 26 && i <= 31) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa2.png"));
				}
				posY -= 33;
			}
			if (i >= 31 && i < 37) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda2.png"));
				}
				posX -= 33;
			}
			if (i >= 37 && i < 39) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa2.png"));
				}
				posY -= 33;
			}
			if (i >= 39 && i <= 44) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita2.png"));
				}
				posX += 33;
			}
			if (i >= 44 && i < 50) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa2.png"));
				}
				posY -= 33;
			}
			if (i >= 50 && i < 51) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita2.png"));
				}
				posX += 33;
			}
			if (i >= 51 && i < 57) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/gaara_frente2.png"));
				}
				posY += 33;
			}

			sleep();
			peca.setIcon(img);
			peca.setLocation(posX, posY);

		}
		peca.setIcon(new ImageIcon(Panel.class.getResource("/resources/gaara_ataque.png")));
		//vozGaara();
		//vozChoji();
		vozKankuro();
		//vozSasuke();
		
		for (int j = 0; j < 4; j++) {
			sleep();
		}
		
	
		peca.setIcon(new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png")));
		peca.setLocation(initialX, initialY);
		
	}

	public void vozGaara() {
		URL url = getClass().getResource("/resources/gaara_sound.wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}
	public void vozKankuro() {
		URL url = getClass().getResource("/resources/kankuro_sound.wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}
	public void vozSasuke() {
		URL url = getClass().getResource("/resources/sasuke_sound.wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}
	public void vozChoji() {
		URL url = getClass().getResource("/resources/choji_sound.wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}


	public void sleep() {
		try {
			TimeUnit.MILLISECONDS.sleep(100);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
