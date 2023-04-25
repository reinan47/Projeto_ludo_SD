package front_end;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import back_end.Jogador;

public class Panel extends JPanel {
	/**
	 *
	 */

	private static final long serialVersionUID = 1L;

	private JLabel tabuleiro = new JLabel(new ImageIcon(Panel.class.getResource("/resources/tabuleiro_jogo.png")));

	private JLabel logo = new JLabel(new ImageIcon(Panel.class.getResource("/resources/logo.png")));

	private JLabel fundo = new JLabel(new ImageIcon(Panel.class.getResource("/resources/fundo.png")));

	private JButton sound = new JButton();

	private tocaTrilhaSonora somFundo = new tocaTrilhaSonora();

	private ImageIcon on = new ImageIcon(getClass().getClassLoader().getResource("resources/on.png"));
	private ImageIcon off = new ImageIcon(getClass().getClassLoader().getResource("resources/off.png"));

	// personagens
	private JLabel[] kankuro = { new JLabel(new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png"))) };

	private JLabel[] choji = { new JLabel(new ImageIcon(Panel.class.getResource("/resources/choji_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/choji_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/choji_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/choji_frente1.png"))) };

	private JLabel[] gaara = { new JLabel(new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png"))) };

	private JLabel[] sasuke = { new JLabel(new ImageIcon(Panel.class.getResource("/resources/sasuke_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/sasuke_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/sasuke_frente1.png"))),
			new JLabel(new ImageIcon(Panel.class.getResource("/resources/sasuke_frente1.png"))) };

	/**
	 * Create the panel.
	 */
	public Panel() {

		// somFundo.start();
		somFundo.setName("som");
		sound.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sound.getIcon().equals(on)) {
					sound.setIcon(off);
					somFundo.stop();

				} else {
					somFundo.start();
					sound.setIcon(on);
				}
			}
		});
		setLocale(null);
		this.setLayout(null);
		sound.setFocusPainted(false);
		sound.setContentAreaFilled(false);
		sound.setOpaque(false);
		sound.setBorder(null);
		sound.setBounds(875, 20, 100, 35);
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
		// new tocaTrilhaSonora().start();
		// espera e deifne vez
		
		new pecas(kankuro, 1 + 1, 1, "kankuro").start();

		new pecas(sasuke, 40 + 1, 2, "sasuke").start();

		new pecas(gaara, 27 + 1, 3, "gaara").start();

		new pecas(choji, 14 + 1, 4, "choji").start();
		
		
		//envia depois de mexido
		
		

	}

}
