package front_end;



import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import back_end.Jogador;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class pecas extends Thread {
	private JLabel peca[];
	private int numDado;
	private int numPlay;
	private String personagem;
	private ImageIcon img;
	private int posX;
	private int posY;
	private int percurso;
	private int numPeca;
	
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

	private int saidaGaaraX = 414;
	private int saidaGaaraY = 544;

	private int saidaSasukeX = 678;
	private int saidaSasukeY = 346;

	private int saidaChojiX = 216;
	private int saidaChojiY = 280;
	// variaveis resposaveis por se movimentar no tabuleiro
	private int posKankuroX = saidaKankuroX;
	private int posKankuroY = saidaKankuroY;

	private int posSasukeX;
	private int posSasukeY;

	private int posGaaraX;
	private int posGaaraY;

	private int posChojiX;
	private int posChojiY;

	public pecas(JLabel peca[], int numDado, int numPlay, String personagem, int percurso, int numPeca) {
		super();
		this.peca = peca;
		this.numDado = numDado;
		this.numPlay = numPlay;
		this.personagem = personagem;
		this.percurso = percurso;
		this.numPeca = numPeca;
	}
	
	public pecas( String personagem, int posX, int posY) {
		this.personagem = personagem;
		this.setPosX(posX);
		this.setPosY(posY);
	}
	

	public void run() {
		//while(true) {
			//as thread ficam escultando e recebendo os valores do server aqui
			jogada(numDado, peca[this.numPeca], numPlay, personagem, this.percurso);
			sleep();sleep();sleep();sleep();sleep();
			jogada(numDado, peca[this.numPeca], numPlay, personagem, this.percurso);
		//}

	}
	
	public void jogada(int numDado, JLabel peca, int numPlay, String personagem, int percurso) {
		if (numPlay == 1) {
			percurso = this.percurso;
			for (int i = 1; i <= numDado; i++) {
				Alternar(i, personagem, "frente");
				if (percurso <= 5) {
					posKankuroY += 33;
				}
				if (percurso >= 5 && percurso < 11) {
					Alternar(i, personagem, "direita");
					posKankuroX += 33;
				}
				if (percurso >= 11 && percurso < 13) {
					Alternar(i, personagem, "frente");
					posKankuroY += 33;
				}
				if (percurso >= 13 && percurso <= 18) {
					Alternar(i, personagem, "esquerda");
					posKankuroX -= 33;
				}
				if (percurso >= 18 && percurso < 24) {
					Alternar(i, personagem, "frente");
					posKankuroY += 33;
				}
				if (percurso >= 24 && percurso < 26) {
					Alternar(i, personagem, "esquerda");
					posKankuroX -= 33;
				}
				if (percurso >= 26 && percurso <= 31) {
					Alternar(i, personagem, "costa");
					posKankuroY -= 33;
				}
				if (percurso >= 31 && percurso < 37) {
					Alternar(i, personagem, "esquerda");
					posKankuroX -= 33;
				}
				if (percurso >= 37 && percurso < 39) {
					Alternar(i, personagem, "costa");
					posKankuroY -= 33;
				}
				if (percurso >= 39 && percurso <= 44) {
					Alternar(i, personagem, "direita");
					posKankuroX += 33;
				}
				if (percurso >= 44 && percurso < 50) {
					Alternar(i, personagem, "costa");
					posKankuroY -= 33;
				}
				if (percurso >= 50 && percurso < 51) {
					Alternar(i, personagem, "direita");
					posKankuroX += 33;
				}
				if (percurso >= 51 && percurso < 57) {
					Alternar(i, personagem, "frente");
					posKankuroY += 33;
				}
				sleep();
				peca.setIcon(img);
				peca.setLocation(posKankuroX, posKankuroY);
				if (percurso == 57) {
					Ataque(peca, personagem);
				}
				percurso += i;
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

	private void Ataque(JLabel peca, String personagem) {
		peca.setIcon(new ImageIcon(Panel.class.getClassLoader().getResource(personagem + "/" + personagem + "_ataque.png")));
		vozPersonagem(personagem);
		for (int j = 0; j < 4; j++) {
			sleep();
		}
		peca.setIcon(new ImageIcon(Panel.class.getClassLoader().getResource(personagem + "/" + personagem + "_frente1.png")));
	}

	private void Alternar(int i, String personage, String coordenada) {
		if (i % 2 == 0) {
			img = new ImageIcon(Panel.class.getClassLoader().getResource(personagem + "/" + personage + "_" + coordenada + "1.png"));
		} else {
			img = new ImageIcon(Panel.class.getClassLoader().getResource(personagem + "/" + personage + "_" + coordenada + "2.png"));
		}
	}

	public void vozPersonagem(String personagem) {
		if (personagem.equals("gaara")) {
			personagem = "gaara";
		}
		if (personagem.equals("sasuke")) {
			personagem = "sasuke";
		}
		if (personagem.equals("kankuro")) {
			personagem = "kankuro";
		}
		if (personagem.equals("choji")) {
			personagem = "choji";
		}
		URL url = getClass().getClassLoader().getResource(personagem + "/" + personagem + "_sound.wav");
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

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}