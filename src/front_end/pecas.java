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
	private int numPlay;
	private ImageIcon img;

	private int initialX;
	private int initialY;
	// casa inicial quando tirar um 6 no sorteio
	private int inicioKankuroX = 480;
	private int inicioKankuroY = 82;

	private int posKankuroX;
	private int posKankuroY;

	private int posSasukeX;
	private int posSasukeY;

	private int posGaaraX;
	private int posGaaraY;

	private int posChojiX;
	private int posChojiY;

	public pecas(JLabel peca[], int numDado, int numPlay) {
		super();
		this.peca = peca;
		this.numDado = numDado;
		this.numPlay = numPlay;
	}

	public void run() {
		// aqui será escolhido a peça que será movimentada e o jogador que irá jogar
		jogada(numDado, peca[0], numPlay);
	}

	public void jogada(int numDado, JLabel peca, int numPlay) {

		posChojiX = peca.getX();
		posChojiY = peca.getY();

		posGaaraX = peca.getX();
		posGaaraY = peca.getY();


		if (numPlay == 1) {
			initialX = peca.getX();
			initialY = peca.getY();
			posKankuroX = peca.getX() - 88;
			posKankuroY = peca.getY() - 50;
			
			for (int i = 0; i < numDado; i++) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente2.png"));
				}

				if (i <= 5) {
					posKankuroY += 33;
				}
				if (i >= 5 && i < 11) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita2.png"));
					}
					posKankuroX += 33;
				}
				if (i >= 11 && i < 13) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente2.png"));
					}
					posKankuroY += 33;
				}
				if (i >= 13 && i <= 18) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda2.png"));
					}
					posKankuroX -= 33;
				}
				if (i >= 18 && i < 24) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente2.png"));
					}
					posKankuroY += 33;
				}
				if (i >= 24 && i < 26) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda2.png"));
					}
					posKankuroX -= 33;
				}
				if (i >= 26 && i <= 31) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa2.png"));
					}
					posKankuroY -= 33;
				}
				if (i >= 31 && i < 37) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_esquerda2.png"));
					}
					posKankuroX -= 33;
				}
				if (i >= 37 && i < 39) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa2.png"));
					}
					posKankuroY -= 33;
				}
				if (i >= 39 && i <= 44) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita2.png"));
					}
					posKankuroX += 33;
				}
				if (i >= 44 && i < 50) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa2.png"));
					}
					posKankuroY -= 33;
				}
				if (i >= 50 && i < 51) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita2.png"));
					}
					posKankuroX += 33;
				}
				if (i >= 51 && i < 57) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_frente2.png"));
					}
					posKankuroY += 33;
				}

				sleep();
				peca.setIcon(img);
				peca.setLocation(posKankuroX, posKankuroY);

			}
		}else if(numPlay == 2) {
			//initialX = peca.getX();
			//initialY = peca.getY();
			posSasukeX = peca.getX() - 88;
			posSasukeY = peca.getY() - 10;
			
			for (int i = 0; i < numDado; i++) {
				if (i % 2 == 0) {
					img = new ImageIcon(Panel.class.getResource("/resources/sasuke_frente1.png"));
				} else {
					img = new ImageIcon(Panel.class.getResource("/resources/sasuke_frente2.png"));
				}

				if (i <= 5) {
					posSasukeY += 33;
				}
				if (i >= 5 && i < 11) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_direita1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_direita2.png"));
					}
					posSasukeX += 33;
				}
				if (i >= 11 && i < 13) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_frente1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_frente2.png"));
					}
					posKankuroY += 33;
				}
				if (i >= 13 && i <= 18) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_esquerda1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_esquerda2.png"));
					}
					posKankuroX -= 33;
				}
				if (i >= 18 && i < 24) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_frente1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_frente2.png"));
					}
					posKankuroY += 33;
				}
				if (i >= 24 && i < 26) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_esquerda1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_esquerda2.png"));
					}
					posKankuroX -= 33;
				}
				if (i >= 26 && i <= 31) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_costa1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_costa2.png"));
					}
					posKankuroY -= 33;
				}
				if (i >= 31 && i < 37) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_esquerda1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_esquerda2.png"));
					}
					posKankuroX -= 33;
				}
				if (i >= 37 && i < 39) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_costa1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_costa2.png"));
					}
					posKankuroY -= 33;
				}
				if (i >= 39 && i <= 44) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_direita1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_direita2.png"));
					}
					posKankuroX += 33;
				}
				if (i >= 44 && i < 50) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/sasuke_costa1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_costa2.png"));
					}
					posKankuroY -= 33;
				}
				if (i >= 50 && i < 51) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/kankuro_direita2.png"));
					}
					posKankuroX += 33;
				}
				if (i >= 51 && i < 57) {
					if (i % 2 == 0) {
						img = new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png"));
					} else {
						img = new ImageIcon(Panel.class.getResource("/resources/gaara_frente2.png"));
					}
					posKankuroY += 33;
				}

				sleep();
				peca.setIcon(img);
				peca.setLocation(posKankuroX, posKankuroY);

			}
		}else if(numPlay == 3) {
			
		}else if(numPlay == 4) {
			
		}
		peca.setIcon(new ImageIcon(Panel.class.getResource("/resources/sasuke_ataque.png")));
		vozGaara();
		// vozChoji();
		// vozKankuro();
		// vozSasuke();

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
