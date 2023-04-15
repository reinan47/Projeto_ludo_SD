package front_end;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JLabel tabuleiro = new JLabel(new ImageIcon(Panel.class.getResource("/resources/tabuleiro_jogo.png")));

	private JLabel logo = new JLabel(new ImageIcon(Panel.class.getResource("/resources/logo.png")));
	
	private JLabel fundo = new JLabel(new ImageIcon(Panel.class.getResource("/resources/fundo.png")));
	/**
	 * Create the panel.
	 */
	public Panel() {
		setLocale(null);
		this.setLayout(null);

		tabuleiro.setBounds(220, 100, 550, 550);
		fundo.setBounds(0, 0, 1000, 700);
		logo.setBounds(442,5,100,193);
		
		add(tabuleiro);
		add(fundo);
		add(logo);

	}

}
