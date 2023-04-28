package front_end;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class frame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Principal principal = new Principal();

	private JLabel ip = new JLabel("IP");
	//private JLabel fundo = new JLabel(new ImageIcon(frame.class.getClassLoader().getResource("naruto.png")));
	private JLabel port = new JLabel("Porta");
	private JTextField ipValue = new JTextField();
	
	private JTextField portValue = new JTextField();
	
	
	private JButton criarPartida = new JButton("Criar Partida");
	private JButton encontrarPartida = new JButton("Entrar em partida");
	private JButton jogar = new JButton("Jogar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frame frame = new frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frame() {
		principal.setLocale(null);
		principal.setLayout(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(400, 10, 500, 700);
		setContentPane(principal);
		criarPartida.setForeground(Color.WHITE);
		criarPartida.setBackground(Color.BLACK);
		criarPartida.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		criarPartida.setBounds(170, 550, 150, 25);
		principal.add(criarPartida);
		encontrarPartida.setForeground(Color.WHITE);
		encontrarPartida.setBackground(Color.BLACK);
		encontrarPartida.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		encontrarPartida.setBounds(170, 400, 150, 25);
		principal.add(encontrarPartida);
		EventoJogar(principal);
		//fundo.setBackground(Color.BLACK);
		//fundo.setText("porta");
		
		// parte q add para se conectar a partida
		//fundo.setBounds(0, 0, 500, 700);
		ipValue.setBackground(new Color(234, 234, 234));
		ipValue.setHorizontalAlignment(SwingConstants.CENTER);
		ipValue.setFont(new Font("Times New Roman", Font.PLAIN, 12));

		ipValue.setBounds(150, 162, 200, 25);
		portValue.setBackground(new Color(234, 234, 234));
		portValue.setHorizontalAlignment(SwingConstants.CENTER);
		portValue.setBounds(207, 262, 80, 25);
		ip.setForeground(new Color(0, 0, 0));
		ip.setToolTipText("");
		ip.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 14));
		ip.setHorizontalAlignment(SwingConstants.CENTER);
		ip.setForeground(Color.WHITE);
		
		ip.setBounds(150, 134, 200, 25);
		port.setForeground(new Color(0, 0, 0));
		port.setHorizontalAlignment(SwingConstants.CENTER);
		port.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 14));
		port.setBounds(207, 236, 80, 25);
		port.setForeground(Color.WHITE);
		
		ip.setVisible(false);
		port.setVisible(false);
		ipValue.setVisible(false);
		portValue.setVisible(false);
		jogar.setForeground(Color.WHITE);
		jogar.setBackground(Color.BLACK);
		jogar.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		
		jogar.setFocusPainted(false);
		jogar.setContentAreaFilled(true);
		
		criarPartida.setFocusPainted(false);
		criarPartida.setContentAreaFilled(true);
		
		encontrarPartida.setFocusPainted(false);
		encontrarPartida.setContentAreaFilled(true);
		
		jogar.setBounds(202, 310, 90, 25);
		jogar.setVisible(false);
		getContentPane().add(ip);
		getContentPane().add(port);
		getContentPane().add(ipValue);
		getContentPane().add(portValue);
		getContentPane().add(jogar);
		//getContentPane().add(fundo);
		
		EventoEntrarPartida();
	}

	public void EventoJogar(Principal principal) {
		criarPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel contentPane = new Panel();
				principal.eventoJogar(criarPartida);
				setContentPane(contentPane);
				setBounds(150, 10, 1000, 700);
				// implementar logica para startar server

			}
		});
	}

	public void EventoEntrarPartida() {
		encontrarPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ipValue.setBounds(150, 162, 200, 25);
				portValue.setBounds(207, 262, 80, 25);
				ip.setOpaque(true);
				port.setOpaque(true);
				ip.setBackground(Color.BLACK);
				port.setBackground(Color.BLACK);
				
				
				ip.setBounds(240, 122, 20, 20);
				port.setBounds(230, 215, 35, 20);
				ip.setVisible(true);
				port.setVisible(true);
				ipValue.setVisible(true);
				portValue.setVisible(true);
				jogar.setVisible(true);
			}
		});
	}
		
		public void EventoJogarPorIpPort() {
			jogar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//implementar pra entrar por porta e ip
				}
			});
	}
}
