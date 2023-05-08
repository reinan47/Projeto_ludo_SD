package front_end;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import back_end.Jogador;

public class Panel extends JPanel {
	/**
	 *
	 */

	private static final long serialVersionUID = 1L;
	pecas p = new pecas();

	private JLabel tabuleiro = new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("tabuleiro_jogo.png")));

	private JLabel logo = new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("logo.png")));

	private JLabel fundo = new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("fundo.png")));

	private JButton sound = new JButton();
	
	private JButton dado = new JButton();

	private tocaTrilhaSonora somFundo = new tocaTrilhaSonora();
	
	private JLabel txtSomFundo = new JLabel("Desativar música");

	private ImageIcon on = new ImageIcon(getClass().getClassLoader().getResource("on.png"));
	private ImageIcon off = new ImageIcon(getClass().getClassLoader().getResource("off.png"));
	private ImageIcon dadoPadrao = new ImageIcon(getClass().getClassLoader().getResource("dado/dado1.png"));

	// personagens
	private JLabel[] kankuro = { new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("kankuro/kankuro_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("kankuro/kankuro_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("kankuro/kankuro_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("kankuro/kankuro_frente1.png"))) };

	private JLabel[] choji = { new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("choji/choji_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("choji/choji_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("choji/choji_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("choji/choji_frente1.png"))) };

	private JLabel[] gaara = { new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("gaara/gaara_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("gaara/gaara_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("gaara/gaara_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("gaara/gaara_frente1.png"))) };

	private JLabel[] sasuke = { new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("sasuke/sasuke_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("sasuke/sasuke_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("sasuke/sasuke_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getClassLoader().getResource("sasuke/sasuke_frente1.png"))) };
	private Jogador jogador = new Jogador(kankuro,sasuke,gaara,choji);
	/**
	 * Create the panel.
	 */
	public Panel() {

		somFundo.start();
		sound.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sound.getIcon().equals(on)) {
					sound.setIcon(off);
					txtSomFundo.setBounds(852, 44, 95, 13);
					txtSomFundo.setBackground(Color.GREEN);
					txtSomFundo.setText("Ativar música");
					somFundo.stopSound();

				} else {
					txtSomFundo.setBounds(840, 44, 122, 13);
					txtSomFundo.setBackground(Color.RED);
					txtSomFundo.setText("Desativar música");
					somFundo.startSound();
					sound.setIcon(on);
				}
			}
		});
		dado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//aki eu passo as referencias dos jogadores e chamo a função de sortear o dado
				//receber função q recebe o retorno do vaor do dado
				dado.setIcon(new ImageIcon(getClass().getClassLoader().getResource("dado/dado" + jogador.numAleatorio() + ".png")));
				//jogador.defineJogador(1);
				//System.out.println(p.jogadaInfo(5, 1, 0, 10, 20, kankuro[3], "kankuro"));
				
			}
		});
		setLocale(null);
		this.setLayout(null);
		dado.setIcon(dadoPadrao);
		dado.setBounds(100, 350, 47, 47);
		add(dado);
		
		txtSomFundo.setBounds(840, 44, 122, 13);
		txtSomFundo.setFont(new Font("Russo One", Font.BOLD, 15));
		txtSomFundo.setForeground(Color.BLACK);
		txtSomFundo.setBackground(Color.RED);
		txtSomFundo.setOpaque(true);
		txtSomFundo.setBackground(Color.RED);
		add(txtSomFundo);
		
		sound.setFocusPainted(false);
		sound.setContentAreaFilled(false);
		sound.setOpaque(false);
		sound.setBorder(null);
		sound.setBounds(850, 75, 100, 35);
		sound.setIcon(on);
		add(sound);

		tabuleiro.setBounds(220, 100, 550, 550);
		fundo.setBounds(0, 0, 1000, 700);
		logo.setBounds(442, 5, 100, 193);

		choji[0].setBounds(272, 132, 98, 87);
		add(choji[0]);
		choji[1].setBounds(327, 132, 98, 87);
		add(choji[1]);
		choji[2].setBounds(272, 187, 98, 87);
		add(choji[2]);
		choji[3].setBounds(327, 187, 98, 87);
		add(choji[3]);

		kankuro[0].setBounds(568, 132, 98, 87);
		add(kankuro[0]);
		kankuro[1].setBounds(622, 132, 98, 87);
		add(kankuro[1]);
		kankuro[2].setBounds(568, 187, 98, 87);
		add(kankuro[2]);
		kankuro[3].setBounds(622, 187, 98, 87);
		add(kankuro[3]);

		gaara[0].setBounds(267, 435, 98, 87);
		add(gaara[0]);
		gaara[1].setBounds(321, 435, 98, 87);
		add(gaara[1]);
		gaara[2].setBounds(267, 490, 98, 87);
		add(gaara[2]);
		gaara[3].setBounds(321, 490, 98, 87);
		add(gaara[3]);

		sasuke[0].setBounds(568, 435, 98, 87);
		add(sasuke[0]);
		sasuke[1].setBounds(622, 435, 98, 87);
		add(sasuke[1]);
		sasuke[2].setBounds(568, 490, 98, 87);
		add(sasuke[2]);
		sasuke[3].setBounds(622, 490, 98, 87);
		add(sasuke[3]);

		add(tabuleiro);
		add(logo);
		add(fundo);


		// de acordo com a resposta do servidor que virá aki será direcionado
		// um vetor com as pecas para uma thread, que moverá a peca de acordo com a
		// jogada,
		// que o servidor sorteará.
		// espera e deifne vez
		
		//new pecas(kankuro, 0, 1, "kankuro").start();

		//new pecas(sasuke, 0, 2, "sasuke").start();

		//new pecas(gaara, 0, 3, "gaara").start();

		
		
		
		//envia depois de mexido
		
		

	}

}
