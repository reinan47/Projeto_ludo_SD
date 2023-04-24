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
	private String personagem;
	private ImageIcon img;
	// posições iniciais de origens das peças
	private int[] initiaKankurolX = { 568, 622, 568, 622 };
	private int[] initialKankuroY = { 132, 132, 187, 187 };

	private int[] initialSasukeX = { 568, 622, 568, 622 };
	private int[] initialSasukeY = { 435, 435, 490, 490 };

	private int[] initialGaaraX = { 267, 321, 267, 321 };
	private int[] initialGaaraY = { 435, 435, 490, 490 };

	private int[] initialChojiX = { 272, 327, 272, 327 };
	private int[] initialChojiY = { 132, 132, 187, 187 };

	// posições das casas iniciais quando tirar um 6 no sorteio
	private int saidaKankuroX = 480;
	private int saidaKankuroY = 82;

	private int saidaGaaraX = 412;
	private int saidaGaaraY = 550;

	private int saidaSasukeX = 678;
	private int saidaSasukeY = 350;

	private int saidaChojiX = 212;
	private int saidaChojiY = 282;
	// variaveis resposaveis por se movimentar no tabuleiro
	private int posKankuroX;
	private int posKankuroY;

	private int posSasukeX;
	private int posSasukeY;

	private int posGaaraX;
	private int posGaaraY;

	private int posChojiX;
	private int posChojiY;

	public pecas(JLabel peca[], int numDado, int numPlay, String personagem) {
		super();
		this.peca = peca;
		this.numDado = numDado;
		this.numPlay = numPlay;
		this.personagem = personagem;
	}

	public void run() {
		// aqui será escolhido a peça que será movimentada e o jogador que irá jogar
		jogada(numDado, peca[0], numPlay, personagem);
		jogada(numDado, peca[1], numPlay, personagem);
		jogada(numDado, peca[2], numPlay, personagem);
		jogada(numDado, peca[3], numPlay, personagem);
	}
	
	public void jogada(int numDado, JLabel peca, int numPlay, String personagem) {
		if (numPlay == 1) {
			posKankuroX = saidaKankuroX;
			posKankuroY = saidaKankuroY;
			for (int i = 0; i < numDado; i++) {
				Alternar(i, personagem, "frente");
				if (i <= 5) {
					posKankuroY += 33;
				}
				if (i >= 5 && i < 11) {
					Alternar(i, personagem, "direita");
					posKankuroX += 33;
				}
				if (i >= 11 && i < 13) {
					Alternar(i, personagem, "frente");
					posKankuroY += 33;
				}
				if (i >= 13 && i <= 18) {
					Alternar(i, personagem, "esquerda");
					posKankuroX -= 33;
				}
				if (i >= 18 && i < 24) {
					Alternar(i, personagem, "frente");
					posKankuroY += 33;
				}
				if (i >= 24 && i < 26) {
					Alternar(i, personagem, "esquerda");
					posKankuroX -= 33;
				}
				if (i >= 26 && i <= 31) {
					Alternar(i, personagem, "costa");
					posKankuroY -= 33;
				}
				if (i >= 31 && i < 37) {
					Alternar(i, personagem, "esquerda");
					posKankuroX -= 33;
				}
				if (i >= 37 && i < 39) {
					Alternar(i, personagem, "costa");
					posKankuroY -= 33;
				}
				if (i >= 39 && i <= 44) {
					Alternar(i, personagem, "direita");
					posKankuroX += 33;
				}
				if (i >= 44 && i < 50) {
					Alternar(i, personagem, "costa");
					posKankuroY -= 33;
				}
				if (i >= 50 && i < 51) {
					Alternar(i, personagem, "direita");
					posKankuroX += 33;
				}
				if (i >= 51 && i < 57) {
					Alternar(i, personagem, "frente");
					posKankuroY += 33;
				}
				sleep();
				peca.setIcon(img);
				peca.setLocation(posKankuroX, posKankuroY);
				if (i == 57) {
					Ataque(peca, personagem);
				}
			}
		} else if (numPlay == 2) {
			posSasukeX = saidaSasukeX;
			posSasukeY = saidaSasukeY;
			for (int i = 0; i < numDado; i++) {
				Alternar(i, personagem, "esquerda");
				if (i <= 5) {
					posSasukeX -= 33;
				}
				if (i >= 5 && i < 11) {
					Alternar(i, personagem, "frente");
					posSasukeY += 33;
				}
				if (i >= 11 && i < 13) {
					Alternar(i, personagem, "esquerda");
					posSasukeX -= 33;
				}
				if (i >= 13 && i <= 18) {
					Alternar(i, personagem, "costa");
					posSasukeY -= 33;
				}
				if (i >= 18 && i < 24) {
					Alternar(i, personagem, "esquerda");
					posSasukeX -= 33;
				}
				if (i >= 24 && i < 26) {
					Alternar(i, personagem, "costa");
					posSasukeY -= 33;
				}
				if (i >= 26 && i <= 31) {
					Alternar(i, personagem, "direita");
					posSasukeX += 33;
				}
				if (i >= 31 && i < 37) {
					Alternar(i, personagem, "costa");
					posSasukeY -= 33;
				}
				if (i >= 37 && i < 39) {
					Alternar(i, personagem, "direita");
					posSasukeX += 33;
				}
				if (i >= 39 && i <= 44) {
					Alternar(i, personagem, "frente");
					posSasukeY += 33;
				}
				if (i >= 44 && i < 50) {
					Alternar(i, personagem, "direita");
					posSasukeX += 33;
				}
				if (i >= 50 && i < 51) {
					Alternar(i, personagem, "frente");
					posSasukeY += 33;
				}
				if (i >= 51 && i < 57) {
					Alternar(i, personagem, "esquerda");
					posSasukeX -= 33;
				}
				sleep();
				peca.setIcon(img);
				peca.setLocation(posSasukeX, posSasukeY);
				if (i == 57) {
					Ataque(peca, personagem);
				}
			}
		} else if (numPlay == 3) {
			posGaaraX = saidaGaaraX;
			posGaaraY = saidaGaaraY;
			for (int i = 0; i < numDado; i++) {
				Alternar(i, personagem, "costa");
				if (i <= 5) {
					posGaaraY -= 33;
				}
				if (i >= 5 && i < 11) {
					Alternar(i, personagem, "esquerda");
					posGaaraX -= 33;
				}
				if (i >= 11 && i < 13) {
					Alternar(i, personagem, "costa");
					posGaaraY -= 33;
				}
				if (i >= 13 && i <= 18) {
					Alternar(i, personagem, "direita");
					posGaaraX += 33;
				}
				if (i >= 18 && i < 24) {
					Alternar(i, personagem, "costa");
					posGaaraY -= 33;
				}
				if (i >= 24 && i < 26) {
					Alternar(i, personagem, "direita");
					posGaaraX += 33;
				}
				if (i >= 26 && i <= 31) {
					Alternar(i, personagem, "frente");
					posGaaraY += 33;
				}
				if (i >= 31 && i < 37) {
					Alternar(i, personagem, "direita");
					posGaaraX += 33;
				}
				if (i >= 37 && i < 39) {
					Alternar(i, personagem, "frente");
					posGaaraY += 33;
				}
				if (i >= 39 && i <= 44) {
					Alternar(i, personagem, "esquerda");
					posGaaraX -= 33;
				}
				if (i >= 44 && i < 50) {
					Alternar(i, personagem, "frente");
					posGaaraY += 33;
				}
				if (i >= 50 && i < 51) {
					Alternar(i, personagem, "esquerda");
					posGaaraX -= 33;
				}
				if (i >= 51 && i < 57) {
					Alternar(i, personagem, "costa");
					posGaaraY -= 33;
				}
				sleep();
				peca.setIcon(img);
				peca.setLocation(posGaaraX, posGaaraY);
				if (i == 57) {
					Ataque(peca, personagem);
				}
			}
		} else if (numPlay == 4) {
			posChojiX = saidaChojiX;
			posChojiY = saidaChojiY;
			for (int i = 0; i < numDado; i++) {
				Alternar(i, personagem, "direita");
				if (i <= 5) {
					posChojiX += 33;
				}
				if (i >= 5 && i < 11) {
					Alternar(i, personagem, "costa");
					posChojiY -= 33;
				}
				if (i >= 11 && i < 13) {
					Alternar(i, personagem, "direita");
					posChojiX += 33;
				}
				if (i >= 13 && i <= 18) {
					Alternar(i, personagem, "frente");
					posChojiY += 33;
				}
				if (i >= 18 && i < 24) {
					Alternar(i, personagem, "direita");
					posChojiX += 33;
				}
				if (i >= 24 && i < 26) {
					Alternar(i, personagem, "frente");
					posChojiY += 33;
				}
				if (i >= 26 && i <= 31) {
					Alternar(i, personagem, "esquerda");
					posChojiX -= 33;
				}
				if (i >= 31 && i < 37) {
					Alternar(i, personagem, "frente");
					posChojiY += 33;
				}
				if (i >= 37 && i < 39) {
					Alternar(i, personagem, "esquerda");
					posChojiX -= 33;
				}
				if (i >= 39 && i <= 44) {
					Alternar(i, personagem, "costa");
					posChojiY -= 33;
				}
				if (i >= 44 && i < 50) {
					Alternar(i, personagem, "esquerda");
					posChojiX -= 33;
				}
				if (i >= 50 && i < 51) {
					Alternar(i, personagem, "costa");
					posChojiY -= 33;
				}
				if (i >= 51 && i < 57) {
					Alternar(i, personagem, "direita");
					posChojiX += 33;
				}
				sleep();
				peca.setIcon(img);
				peca.setLocation(posChojiX, posChojiY);
				if (i == 57) {
					Ataque(peca, personagem);
				}
			}
		}
	}

	private void Ataque(JLabel peca, String play) {
		peca.setIcon(new ImageIcon(Panel.class.getResource("/resources/" + play + "_ataque.png")));
		for (int j = 0; j < 4; j++) {
			sleep();
		}
		peca.setIcon(new ImageIcon(Panel.class.getResource("/resources/" + play + "_frente1.png")));
		vozPersonagem(play);
	}

	private void Alternar(int i, String personage, String coordenada) {
		if (i % 2 == 0) {
			img = new ImageIcon(Panel.class.getResource("/resources/" + personage + "_" + coordenada + "1.png"));
		} else {
			img = new ImageIcon(Panel.class.getResource("/resources/" + personage + "_" + coordenada + "2.png"));
		}
	}

	public void vozPersonagem(String name) {
		if (name.equals("gaara")) {
			name = "gaara";
		}
		if (name.equals("sasuke")) {
			name = "sasuke";
		}
		if (name.equals("kankuro")) {
			name = "kankuro";
		}
		if (name.equals("choji")) {
			name = "choji";
		}
		URL url = getClass().getResource("/resources/" + name + "_sound.wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}

	public void sleep() {
		try {
			TimeUnit.MILLISECONDS.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}