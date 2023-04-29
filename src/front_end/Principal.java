package front_end;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JPanel{
	public Principal() {
	}

	public void eventoJogar(JButton jogar) {
		jogar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel contentPane = new Panel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
	}
	
}
