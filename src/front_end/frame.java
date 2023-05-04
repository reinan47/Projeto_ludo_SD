package front_end;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import back_end.Servidor;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class frame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Principal principal = new Principal();
	private Servidor server = new Servidor();

	private JLabel ip = new JLabel("IP");
	private JLabel fundo = new JLabel(new ImageIcon(frame.class.getClassLoader().getResource("naruto.png")));
	private JLabel port = new JLabel("Porta");
	private JTextField ipValue = new JTextField();

	private JTextField portValue = new JTextField();
	private JButton criarPartida = new JButton(
			new ImageIcon(frame.class.getClassLoader().getResource("criar_partida .png")));
	private JButton encontrarPartida = new JButton(
			new ImageIcon(frame.class.getClassLoader().getResource("entrar_partida.png")));

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
		criarPartida.setFocusPainted(false);
		criarPartida.setContentAreaFilled(false);
		criarPartida.setOpaque(false);
		criarPartida.setBorder(null);
		criarPartida.setBounds(120, 550, 250, 50);
		principal.add(criarPartida);

		encontrarPartida.setFocusPainted(false);
		encontrarPartida.setContentAreaFilled(false);
		encontrarPartida.setOpaque(false);
		encontrarPartida.setBorder(null);
		encontrarPartida.setBounds(90, 400, 300, 74);
		principal.add(encontrarPartida);

		fundo.setBackground(Color.BLACK);
		fundo.setText("porta");

		// parte q add para se conectar a partida
		fundo.setBounds(0, 0, 500, 700);
		ipValue.setBackground(new Color(234, 234, 234));
		ipValue.setHorizontalAlignment(SwingConstants.CENTER);
		ipValue.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		ipValue.setBounds(150, 162, 200, 25);
		portValue.setBackground(new Color(234, 234, 234));
		portValue.setHorizontalAlignment(SwingConstants.CENTER);
		portValue.setBounds(207, 262, 80, 25);
		portValue.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		ip.setForeground(new Color(0, 0, 0));
		ip.setToolTipText("");
		ip.setFont(new Font("Chewy", Font.BOLD, 18));
		ip.setHorizontalAlignment(SwingConstants.CENTER);
		ip.setForeground(Color.BLACK);
		ip.setBounds(150, 134, 200, 25);

		port.setForeground(new Color(0, 0, 0));
		port.setHorizontalAlignment(SwingConstants.CENTER);
		port.setFont(new Font("Chewy", Font.BOLD, 18));
		port.setBounds(207, 236, 80, 25);

		ipValue.setBounds(150, 192, 200, 25);
		portValue.setBounds(207, 292, 80, 25);
		ip.setOpaque(false);
		port.setOpaque(false);

		ip.setBounds(240, 167, 20, 20);
		port.setBounds(222, 265, 50, 20);


		getContentPane().add(ip);
		getContentPane().add(port);
		getContentPane().add(ipValue);
		getContentPane().add(portValue);
		getContentPane().add(fundo);

		EventoEntrarPartida();
		EventoJogar(principal);
		EventosMouse();
	}

	public void EventoJogar(Principal principal) {
		criarPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel contentPane = new Panel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setBounds(150, 10, 1000, 700);
				contentPane.repaint();
				contentPane.revalidate();
				setContentPane(contentPane);

				// implementar logica para startar server

			}
		});
	}

	public void EventoEntrarPartida() {
		encontrarPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public void EventosMouse() {
		criarPartida.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				somClick();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				criarPartida.setBounds(120, 550, 250, 50);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				criarPartida.setBounds(120, 545, 250, 50);
				somHover();

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		encontrarPartida.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				somClick();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				encontrarPartida.setBounds(90, 400, 300, 74);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				encontrarPartida.setBounds(90, 395, 300, 74);
				somHover();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void somClick() {
		URL url = getClass().getClassLoader().getResource("naruto_pressed.wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}

	public void somHover() {
		URL url = getClass().getClassLoader().getResource("hover.wav");
		AudioClip audio = Applet.newAudioClip(url);
		audio.play();
	}
}
