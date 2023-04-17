package front_end;

import java.util.concurrent.TimeUnit;

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
	
	//personagens
	private JLabel kankuro1 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png")));
	private JLabel kankuro2 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png")));
	private JLabel kankuro3 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png")));
	private JLabel kankuro4 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/kankuro_frente1.png")));
	
	private JLabel choji1 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/choji_frente1.png")));
	private JLabel choji2 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/choji_frente1.png")));
	private JLabel choji3 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/choji_frente1.png")));
	private JLabel choji4 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/choji_frente1.png")));
	
	private JLabel gaara1 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png")));
	private JLabel gaara2 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png")));
	private JLabel gaara3 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png")));
	private JLabel gaara4 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/gaara_frente1.png")));
	
	private JLabel konohamaru1 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/konohamaru_frente1.png")));
	private JLabel konohamaru2 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/konohamaru_frente1.png")));
	private JLabel konohamaru3 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/konohamaru_frente1.png")));
	private JLabel konohamaru4 = new JLabel(new ImageIcon(Panel.class.getResource("/resources/konohamaru_frente1.png")));
	/**
	 * Create the panel.
	 */
	public Panel() {
		setLocale(null);
		this.setLayout(null);

		tabuleiro.setBounds(220, 100, 550, 550);
		fundo.setBounds(0, 0, 1000, 700);
		logo.setBounds(442,5,100,193);
		
		choji1.setBounds(300, 145, 35, 64);
		add(choji1);
		choji2.setBounds(355, 145, 35, 64);
		add(choji2);
		choji3.setBounds(300, 200, 35, 64);
		add(choji3);
		choji4.setBounds(355, 200, 35, 64);
		add(choji4);
		
		kankuro1.setBounds(600, 145, 35, 64);
		add(kankuro1);
		kankuro2.setBounds(655, 145, 35, 64);
		add(kankuro2);
		kankuro3.setBounds(600, 200, 35, 64);
		add(kankuro3);
		kankuro4.setBounds(655, 200, 35, 64);
		add(kankuro4);
		
		gaara1.setBounds(300, 445, 35, 64);
		add(gaara1);
		gaara2.setBounds(355, 445, 35, 64);
		add(gaara2);
		gaara3.setBounds(300, 500, 35, 64);
		add(gaara3);
		gaara4.setBounds(355, 500, 35, 64);
		add(gaara4);
		
		konohamaru1.setBounds(600, 445, 35, 64);
		add(konohamaru1);
		konohamaru2.setBounds(655, 445, 35, 64);
		add(konohamaru2);
		konohamaru3.setBounds(600, 500, 35, 64);
		add(konohamaru3);
		konohamaru4.setBounds(655, 500, 35, 64);
		add(konohamaru4);
		
		
		add(tabuleiro);
		add(logo);
		add(fundo);
		new pecas(kankuro1).start();; 
		
		

	}

}
