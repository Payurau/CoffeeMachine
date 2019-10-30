import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Versiotiedot extends JFrame {

	private JPanel contentPane;
	private JLabel lblJuomaautomaattiVersio;
	private JLabel lblTekijPauliinaRauramo;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Versiotiedot frame = new Versiotiedot();
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
	public Versiotiedot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJuomaautomaattiVersio = new JLabel("Juoma-automaatti versio 1.0");
		lblJuomaautomaattiVersio.setFont(new Font("Arial", Font.PLAIN, 30));
		lblJuomaautomaattiVersio.setBounds(75, 10, 475, 158);
		contentPane.add(lblJuomaautomaattiVersio);
		
		lblTekijPauliinaRauramo = new JLabel("Tekijä: Pauliina Rauramo");
		lblTekijPauliinaRauramo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblTekijPauliinaRauramo.setBounds(98, 363, 448, 69);
		contentPane.add(lblTekijPauliinaRauramo);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Versiotiedot.class.getResource("/img/coffee-machine.png")));
		label.setBounds(129, 118, 329, 251);
		contentPane.add(label);
	}

}
