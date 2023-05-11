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
	private int indexPeca;
	private int percurso;
	private int getX;
	private int getY;
	
	
	private ImageIcon img;
	private int posX;
	private int posY;
	
	private String informacoesParaCliente = null; 
	

	// posições iniciais de origens das peças
	private int[] initialKankuroX = { 568, 622, 568, 622 };
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

	public pecas(int numDado, int numPlay, int percurso, int getX, int getY, int indexPeca, String personagem, JLabel[] peca) {
		super();
		this.numDado = numDado;
		this.numPlay = numPlay;
		this.percurso = percurso;
		this.getX = getX;
		this.getY = getY;
		this.indexPeca = indexPeca;
		this.personagem = personagem;
		this.peca = peca;
	}
	public pecas() {}

	public void run() {
		//criar vetor de percurso
		jogada(numDado, numPlay, percurso, getX, getY, peca[indexPeca], personagem);
	}

	public void jogada(int numDado, int numPlay, int percurso, int getX, int getY, JLabel peca, String personagem) {
		if (numPlay == 1) {
			posKankuroX = getX;
			posKankuroY = getY;
			for (int i = 0; i < numDado; i++) {
				if (percurso <= 5) {
					posKankuroY += 33;
					Alternar(percurso, personagem, "frente", posKankuroX, posKankuroY, peca);
					if (percurso == 5) {
						posKankuroX = 513;
						posKankuroY = 280;
						Alternar(percurso, personagem, "direita", posKankuroX, posKankuroY, peca);
					}
					percurso++;
				} else if (percurso > 5 && percurso < 11) {
					percurso++;
					posKankuroX += 33;
					Alternar(percurso, personagem, "direita", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 11 && percurso < 13) {
					percurso++;
					posKankuroY += 33;
					Alternar(percurso, personagem, "frente", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 13 && percurso < 18) {
					posKankuroX -= 33;
					Alternar(percurso, personagem, "esquerda", posKankuroX, posKankuroY, peca);
					percurso++;
				} else if (percurso >= 18 && percurso < 24) {
					if (percurso == 18) {
						posKankuroX = 480;
						posKankuroY = 346;
						Alternar(percurso, personagem, "frente", posKankuroX, posKankuroY, peca);
					}
					percurso++;
					posKankuroY += 33;
					Alternar(percurso, personagem, "frente", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 24 && percurso < 26) {
					percurso++;
					posKankuroX -= 33;
					Alternar(i, personagem, "esquerda", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 26 && percurso < 31) {
					posKankuroY -= 33;
					percurso++;
					Alternar(i, personagem, "costa", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 31 && percurso < 37) {
					if (percurso == 31) {
						posKankuroX = 414;
						posKankuroY = 346;
						Alternar(percurso, personagem, "esquerda", posKankuroX, posKankuroY, peca);
					}
					posKankuroX -= 33;
					percurso++;
					Alternar(percurso, personagem, "esquerda", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 37 && percurso < 39) {
					posKankuroY -= 33;
					percurso++;
					Alternar(percurso, personagem, "costa", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 39 && percurso < 44) {
					posKankuroX += 33;
					percurso++;
					Alternar(percurso, personagem, "direita", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 44 && percurso < 50) {
					if (percurso == 44) {
						posKankuroX = 414;
						posKankuroY = 280;
						Alternar(percurso, personagem, "costa", posKankuroX, posKankuroY, peca);
					}
					posKankuroY -= 33;
					percurso++;
					Alternar(percurso, personagem, "costa", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 50 && percurso < 51) {
					posKankuroX += 33;
					percurso++;
					Alternar(percurso, personagem, "direita", posKankuroX, posKankuroY, peca);
				} else if (percurso >= 51 && percurso < 58) {
					posKankuroY += 33;
					percurso++;
					Alternar(percurso, personagem, "frente", posKankuroX, posKankuroY, peca);
				}
				sleep();
				peca.setIcon(img);
				if (percurso == 57) {
					// bota logica pra remover a peça
					Ataque(peca, personagem);
				}

			}
		} else if (numPlay == 2) {
			posSasukeX = getX;
			posSasukeY = getY;
			for (int i = 0; i < numDado; i++) {
				if (percurso <= 5) {
					posSasukeX -= 33;
					Alternar(percurso, personagem, "esquerda", posSasukeX, posSasukeY, peca);
					if (percurso == 5) {
						posSasukeX = 480;
						posSasukeY = 379;
						Alternar(percurso, personagem, "frente", posSasukeX, posSasukeY, peca);
					}
					percurso++;
				} else if (percurso > 5 && percurso < 11) {
					percurso++;
					posSasukeY += 33;
					Alternar(percurso, personagem, "frente", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 11 && percurso < 13) {
					percurso++;
					posSasukeX -= 33;
					Alternar(percurso, personagem, "esquerda", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 13 && percurso < 18) {
					posSasukeY -= 33;
					Alternar(percurso, personagem, "costa", posSasukeX, posSasukeY, peca);
					percurso++;
				} else if (percurso >= 18 && percurso < 24) {
					if (percurso == 18) {
						posSasukeX = 414;
						posSasukeY = 346;
						Alternar(percurso, personagem, "esquerda", posSasukeX, posSasukeY, peca);
					}
					percurso++;
					posSasukeX -= 33;
					Alternar(percurso, personagem, "esquerda", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 24 && percurso < 26) {
					percurso++;
					posSasukeY -= 33;
					Alternar(percurso, personagem, "costa", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 26 && percurso < 31) {
					posSasukeX += 33;
					percurso++;
					Alternar(percurso, personagem, "direita", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 31 && percurso < 37) {
					if (percurso == 31) {
						posSasukeX = 414;
						posSasukeY = 280;
						Alternar(percurso, personagem, "costa", posSasukeX, posSasukeY, peca);
					}
					posSasukeY -= 33;
					percurso++;
					Alternar(i, personagem, "costa", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 37 && percurso < 39) {
					posSasukeX += 33;
					percurso++;
					Alternar(i, personagem, "direita", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 39 && percurso < 44) {
					posSasukeY += 33;
					percurso++;
					Alternar(i, personagem, "frente", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 44 && percurso < 50) {
					if (percurso == 44) {
						posSasukeX = 480;
						posSasukeY = 280;
						Alternar(percurso, personagem, "direita", posSasukeX, posSasukeY, peca);
					}
					posSasukeX += 33;
					percurso++;
					Alternar(percurso, personagem, "direita", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 50 && percurso < 51) {
					posSasukeY += 33;
					percurso++;
					Alternar(percurso, personagem, "frente", posSasukeX, posSasukeY, peca);
				} else if (percurso >= 51 && percurso < 58) {
					posSasukeX -= 33;
					percurso++;
					Alternar(percurso, personagem, "esquerda", posSasukeX, posSasukeY, peca);
				}
				sleep();
				peca.setIcon(img);
				if (percurso == 57) {
					// bota logica pra remover a peça
					Ataque(peca, personagem);
				}
			}
		} else if (numPlay == 3) {
			posGaaraX = getX;
			posGaaraY = getY;
			for (int i = 0; i < numDado; i++) {
				if (percurso <= 5) {
					posGaaraY -= 33;
					Alternar(percurso, personagem, "costa", posGaaraX, posGaaraY, peca);
					if (percurso == 5) {
						posGaaraX = 381;
						posGaaraY = 346;
						Alternar(percurso, personagem, "esquerda", posGaaraX, posGaaraY, peca);
					}
					percurso++;
				} else if (percurso > 5 && percurso < 11) {
					percurso++;
					posGaaraX -= 33;
					Alternar(percurso, personagem, "esquerda", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 11 && percurso < 13) {
					percurso++;
					posGaaraY -= 33;
					Alternar(percurso, personagem, "costa", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 13 && percurso < 18) {
					posGaaraX += 33;
					Alternar(percurso, personagem, "direita", posGaaraX, posGaaraY, peca);
					percurso++;
				} else if (percurso >= 18 && percurso < 24) {
					if (percurso == 18) {
						posGaaraX = 414;
						posGaaraY = 280;
						Alternar(percurso, personagem, "costa", posGaaraX, posGaaraY, peca);
					}
					percurso++;
					posGaaraY -= 33;
					Alternar(percurso, personagem, "costa", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 24 && percurso < 26) {
					percurso++;
					posGaaraX += 33;
					Alternar(percurso, personagem, "direita", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 26 && percurso < 31) {
					posGaaraY += 33;
					percurso++;
					Alternar(percurso, personagem, "frente", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 31 && percurso < 37) {
					if (percurso == 31) {
						posGaaraX = 480;
						posGaaraY = 280;
						Alternar(percurso, personagem, "direita", posGaaraX, posGaaraY, peca);
					}
					posGaaraX += 33;
					percurso++;
					Alternar(percurso, personagem, "direita", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 37 && percurso < 39) {
					posGaaraY += 33;
					percurso++;
					Alternar(percurso, personagem, "frente", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 39 && percurso < 44) {
					posGaaraX -= 33;
					percurso++;
					Alternar(percurso, personagem, "esquerda", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 44 && percurso < 50) {
					if (percurso == 44) {
						posGaaraX = 480;
						posGaaraY = 346;
						Alternar(percurso, personagem, "frente", posGaaraX, posGaaraY, peca);
					}
					posGaaraY += 33;
					percurso++;
					Alternar(percurso, personagem, "frente", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 50 && percurso < 51) {
					posGaaraX -= 33;
					percurso++;
					Alternar(percurso, personagem, "esquerda", posGaaraX, posGaaraY, peca);
				} else if (percurso >= 51 && percurso < 58) {
					posGaaraY -= 33;
					percurso++;
					Alternar(percurso, personagem, "costa", posGaaraX, posGaaraY, peca);
				}
				sleep();
				peca.setIcon(img);
				if (percurso == 57) {
					// bota logica pra remover a peça
					Ataque(peca, personagem);
				}
			}
		} else if (numPlay == 4) {
			posChojiX = getX;
			posChojiY = getY;
			for (int i = 0; i < numDado; i++) {
				if (percurso <= 5) {
					posChojiX += 33;
					Alternar(percurso, personagem, "direita", posChojiX, posChojiY, peca);
					if (percurso == 5) {
						posChojiX = 414;
						posChojiY = 247;
						Alternar(percurso, personagem, "costa", posChojiX, posChojiY, peca);
					}
					percurso++;
				} else if (percurso > 5 && percurso < 11) {
					percurso++;
					posChojiY -= 33;
					Alternar(percurso, personagem, "costa", posChojiX, posChojiY, peca);
				} else if (percurso >= 11 && percurso < 13) {
					percurso++;
					posChojiX += 33;
					Alternar(percurso, personagem, "esquerda", posChojiX, posChojiY, peca);
				} else if (percurso >= 13 && percurso < 18) {
					posChojiY += 33;
					Alternar(percurso, personagem, "frente", posChojiX, posChojiY, peca);
					percurso++;
				} else if (percurso >= 18 && percurso < 24) {
					if (percurso == 18) {
						posChojiX = 480;
						posChojiY = 280;
						Alternar(percurso, personagem, "direita", posChojiX, posChojiY, peca);
					}
					percurso++;
					posChojiX += 33;
					Alternar(percurso, personagem, "direita", posChojiX, posChojiY, peca);
				} else if (percurso >= 24 && percurso < 26) {
					percurso++;
					posChojiY += 33;
					Alternar(i, personagem, "frente", posChojiX, posChojiY, peca);
				} else if (percurso >= 26 && percurso < 31) {
					posChojiX -= 33;
					percurso++;
					Alternar(i, personagem, "esquerda", posChojiX, posChojiY, peca);
				} else if (percurso >= 31 && percurso < 37) {
					if (percurso == 31) {
						posChojiX = 480;
						posChojiY = 346;
						Alternar(percurso, personagem, "frente", posChojiX, posChojiY, peca);
					}
					posChojiY += 33;
					percurso++;
					Alternar(percurso, personagem, "frente", posChojiX, posChojiY, peca);
				} else if (percurso >= 37 && percurso < 39) {
					posChojiX -= 33;
					percurso++;
					Alternar(percurso, personagem, "esquerda", posChojiX, posChojiY, peca);
				} else if (percurso >= 39 && percurso < 44) {
					posChojiY -= 33;
					percurso++;
					Alternar(percurso, personagem, "costa", posChojiX, posChojiY, peca);
				} else if (percurso >= 44 && percurso < 50) {
					if (percurso == 44) {
						posChojiX = 414;
						posChojiY = 346;
						Alternar(percurso, personagem, "esquerda", posChojiX, posChojiY, peca);
					}
					posChojiX -= 33;
					percurso++;
					Alternar(percurso, personagem, "esquerda", posChojiX, posChojiY, peca);
				} else if (percurso >= 50 && percurso < 51) {
					posChojiY -= 33;
					percurso++;
					Alternar(percurso, personagem, "costa", posChojiX, posChojiY, peca);
				} else if (percurso >= 51 && percurso < 58) {
					posChojiX += 33;
					percurso++;
					Alternar(percurso, personagem, "direita", posChojiX, posChojiY, peca);
				}
				sleep();
				peca.setIcon(img);
				if (percurso == 57) {
					// bota logica pra remover a peça
					Ataque(peca, personagem);
				}
			}
		}
		informacoesParaCliente = numDado+";"+numPlay+";"+percurso+";"+getX+";"+getY+";"+indexPeca+";"+personagem;
	}
	public String jogadaInfo(int numDado, int numPlay, int percurso, int getX, int getY) {
		if (numPlay == 1) {
			posKankuroX = getX;
			posKankuroY = getY;
			for (int i = 0; i < numDado; i++) {
				if (percurso <= 5) {
					posKankuroY += 33;
					if (percurso == 5) {
						posKankuroX = 513;
						posKankuroY = 280;
					}
					percurso++;
				} else if (percurso > 5 && percurso < 11) {
					percurso++;
					posKankuroX += 33;
				} else if (percurso >= 11 && percurso < 13) {
					percurso++;
					posKankuroY += 33;
				} else if (percurso >= 13 && percurso < 18) {
					posKankuroX -= 33;
					percurso++;
				} else if (percurso >= 18 && percurso < 24) {
					if (percurso == 18) {
						posKankuroX = 480;
						posKankuroY = 346;
					}
					percurso++;
					posKankuroY += 33;
				} else if (percurso >= 24 && percurso < 26) {
					percurso++;
					posKankuroX -= 33;
				} else if (percurso >= 26 && percurso < 31) {
					posKankuroY -= 33;
					percurso++;
				} else if (percurso >= 31 && percurso < 37) {
					if (percurso == 31) {
						posKankuroX = 414;
						posKankuroY = 346;
					}
					posKankuroX -= 33;
					percurso++;
				} else if (percurso >= 37 && percurso < 39) {
					posKankuroY -= 33;
					percurso++;
				} else if (percurso >= 39 && percurso < 44) {
					posKankuroX += 33;
					percurso++;
				} else if (percurso >= 44 && percurso < 50) {
					if (percurso == 44) {
						posKankuroX = 414;
						posKankuroY = 280;
					}
					posKankuroY -= 33;
					percurso++;
				} else if (percurso >= 50 && percurso < 51) {
					posKankuroX += 33;
					percurso++;
				} else if (percurso >= 51 && percurso < 58) {
					posKankuroY += 33;
					percurso++;
				}

			}
		} else if (numPlay == 2) {
			posSasukeX = getX;
			posSasukeY = getY;
			for (int i = 0; i < numDado; i++) {
				if (percurso <= 5) {
					posSasukeX -= 33;
					if (percurso == 5) {
						posSasukeX = 480;
						posSasukeY = 379;
					}
					percurso++;
				} else if (percurso > 5 && percurso < 11) {
					percurso++;
					posSasukeY += 33;
				} else if (percurso >= 11 && percurso < 13) {
					percurso++;
					posSasukeX -= 33;
				} else if (percurso >= 13 && percurso < 18) {
					posSasukeY -= 33;
					percurso++;
				} else if (percurso >= 18 && percurso < 24) {
					if (percurso == 18) {
						posSasukeX = 414;
						posSasukeY = 346;
					}
					percurso++;
					posSasukeX -= 33;
				} else if (percurso >= 24 && percurso < 26) {
					percurso++;
					posSasukeY -= 33;
				} else if (percurso >= 26 && percurso < 31) {
					posSasukeX += 33;
					percurso++;
				} else if (percurso >= 31 && percurso < 37) {
					if (percurso == 31) {
						posSasukeX = 414;
						posSasukeY = 280;
					}
					posSasukeY -= 33;
					percurso++;
				} else if (percurso >= 37 && percurso < 39) {
					posSasukeX += 33;
					percurso++;
				} else if (percurso >= 39 && percurso < 44) {
					posSasukeY += 33;
					percurso++;
				} else if (percurso >= 44 && percurso < 50) {
					if (percurso == 44) {
						posSasukeX = 480;
						posSasukeY = 280;
					}
					posSasukeX += 33;
					percurso++;
				} else if (percurso >= 50 && percurso < 51) {
					posSasukeY += 33;
					percurso++;
				} else if (percurso >= 51 && percurso < 58) {
					posSasukeX -= 33;
					percurso++;
				}
			}
		} else if (numPlay == 3) {
			posGaaraX = getX;
			posGaaraY = getY;
			for (int i = 0; i < numDado; i++) {
				if (percurso <= 5) {
					posGaaraY -= 33;
					if (percurso == 5) {
						posGaaraX = 381;
						posGaaraY = 346;
					}
					percurso++;
				} else if (percurso > 5 && percurso < 11) {
					percurso++;
					posGaaraX -= 33;
				} else if (percurso >= 11 && percurso < 13) {
					percurso++;
					posGaaraY -= 33;
				} else if (percurso >= 13 && percurso < 18) {
					posGaaraX += 33;
					percurso++;
				} else if (percurso >= 18 && percurso < 24) {
					if (percurso == 18) {
						posGaaraX = 414;
						posGaaraY = 280;
					}
					percurso++;
					posGaaraY -= 33;
				} else if (percurso >= 24 && percurso < 26) {
					percurso++;
					posGaaraX += 33;
				} else if (percurso >= 26 && percurso < 31) {
					posGaaraY += 33;
					percurso++;
				} else if (percurso >= 31 && percurso < 37) {
					if (percurso == 31) {
						posGaaraX = 480;
						posGaaraY = 280;
					}
					posGaaraX += 33;
					percurso++;
				} else if (percurso >= 37 && percurso < 39) {
					posGaaraY += 33;
					percurso++;
				} else if (percurso >= 39 && percurso < 44) {
					posGaaraX -= 33;
					percurso++;
				} else if (percurso >= 44 && percurso < 50) {
					if (percurso == 44) {
						posGaaraX = 480;
						posGaaraY = 346;
					}
					posGaaraY += 33;
					percurso++;
				} else if (percurso >= 50 && percurso < 51) {
					posGaaraX -= 33;
					percurso++;
				} else if (percurso >= 51 && percurso < 58) {
					posGaaraY -= 33;
					percurso++;
				}
			}
		} else if (numPlay == 4) {
			posChojiX = getX;
			posChojiY = getY;
			for (int i = 0; i < numDado; i++) {
				if (percurso <= 5) {
					posChojiX += 33;
					if (percurso == 5) {
						posChojiX = 414;
						posChojiY = 247;
					}
					percurso++;
				} else if (percurso > 5 && percurso < 11) {
					percurso++;
					posChojiY -= 33;
				} else if (percurso >= 11 && percurso < 13) {
					percurso++;
					posChojiX += 33;
				} else if (percurso >= 13 && percurso < 18) {
					posChojiY += 33;
					percurso++;
				} else if (percurso >= 18 && percurso < 24) {
					if (percurso == 18) {
						posChojiX = 480;
						posChojiY = 280;
					}
					percurso++;
					posChojiX += 33;
				} else if (percurso >= 24 && percurso < 26) {
					percurso++;
					posChojiY += 33;
				} else if (percurso >= 26 && percurso < 31) {
					posChojiX -= 33;
					percurso++;
				} else if (percurso >= 31 && percurso < 37) {
					if (percurso == 31) {
						posChojiX = 480;
						posChojiY = 346;
					}
					posChojiY += 33;
					percurso++;
				} else if (percurso >= 37 && percurso < 39) {
					posChojiX -= 33;
					percurso++;
				} else if (percurso >= 39 && percurso < 44) {
					posChojiY -= 33;
					percurso++;
				} else if (percurso >= 44 && percurso < 50) {
					if (percurso == 44) {
						posChojiX = 414;
						posChojiY = 346;
					}
					posChojiX -= 33;
					percurso++;
				} else if (percurso >= 50 && percurso < 51) {
					posChojiY -= 33;
					percurso++;
				} else if (percurso >= 51 && percurso < 58) {
					posChojiX += 33;
					percurso++;
				}
				if (percurso == 57) {
					// bota logica pra remover a peça
				}
			}
		}
		informacoesParaCliente = numDado+";"+numPlay+";"+percurso+";"+getX+";"+getY;
		return informacoesParaCliente;
	}

	private void Ataque(JLabel peca, String personagem) {
		peca.setIcon(
				new ImageIcon(Panel.class.getClassLoader().getResource(personagem + "/" + personagem + "_ataque.png")));
		vozPersonagem(personagem);
		for (int j = 0; j < 4; j++) {
			sleep();
		}
		peca.setIcon(new ImageIcon(
				Panel.class.getClassLoader().getResource(personagem + "/" + personagem + "_frente1.png")));
	}

	private void Alternar(int i, String personage, String coordenada, int posX, int posY, JLabel peca) {
		if (i % 2 == 1) {
			img = new ImageIcon(Panel.class.getClassLoader()
					.getResource(personagem + "/" + personage + "_" + coordenada + "1.png"));
		} else {
			img = new ImageIcon(Panel.class.getClassLoader()
					.getResource(personagem + "/" + personage + "_" + coordenada + "2.png"));
		}
		peca.setLocation(posX, posY);
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
			TimeUnit.MILLISECONDS.sleep(250);
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