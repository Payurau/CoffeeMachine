import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitell��n t��ll� jotta komponentteihin voidaan viitata mist� tahansa luokan
	// sis�lt�

	JPanel contentPane;
	private JMenuItem mntmTallennaAutomaatinTila;
	private JMenuItem mntmLataaAutomaatti;
	private JButton kahvinappi;
	private JButton kaakaonappi;
	private JButton teenappi;
	private JLabel lblKahvi;
	private JLabel lblTee;
	private JLabel lblKaakao;
	private JLabel kahvimaara;
	private JLabel teemaara;
	private JLabel kaakaomaara;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem asetakahvi;
	private JMenuItem asetatee;
	private JMenuItem asetakaakao;
	private JMenuItem mntmTallennaAutomaatinTila_1;
	private JMenuItem mntmLataaAutomaatti_1;
	private JMenuItem mntmLopeta;
	private JMenu mnTietoja;
	private JMenuItem mntmVersiotiedot;
	private JLabel lblKahvia;
	private JLabel lblTeet;
	private JLabel lblKaakaota;

	/**
	 * Main-metodi, joka k�ynnist�� sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// K�ytt�liittym� saa parametrina olion, jonka tiedot se n�ytt��
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan k�ytt�liittym�. Huomaa, ett� otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. T�m� siksi, ett� voidaan n�ytt�� sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		// Ikkunan otsikko ja koko

		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 605);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Ylläpito");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 16));
		menuBar.add(mnNewMenu);
		
		asetakahvi = new JMenuItem("Aseta kahvin määrä");
		asetakahvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner lukija = new Scanner(System.in);
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiKahvi = Integer.parseInt(uusiArvo);
				ja.setKahvi(uusiKahvi);
				kahvimaara.setText(uusiArvo);

			}
		});
		mnNewMenu.add(asetakahvi);
		
		asetatee = new JMenuItem("Aseta teen määrä");
		asetatee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner lukija = new Scanner(System.in);
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiTee = Integer.parseInt(uusiArvo);
				ja.setTee(uusiTee);
				teemaara.setText(uusiArvo);
			}
		});
		mnNewMenu.add(asetatee);
		
		asetakaakao = new JMenuItem("Aseta kaakaon määrä");
		asetakaakao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner lukija = new Scanner(System.in);
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiKaakao = Integer.parseInt(uusiArvo);
				ja.setKaakao(uusiKaakao);
				kaakaomaara.setText(uusiArvo);
			}
		});
		mnNewMenu.add(asetakaakao);
		
		mntmTallennaAutomaatinTila_1 = new JMenuItem("Tallenna automaatin tila");
		mntmTallennaAutomaatinTila_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sarjallistamista.kirjoitaTiedostoon(ja);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmTallennaAutomaatinTila_1);
		
		mntmLataaAutomaatti_1 = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
					ja.setKahvi(uusi.getKahvi());
					ja.setTee(uusi.getTee());
					ja.setKaakao(uusi.getKaakao());
					teemaara.setText(String.valueOf(uusi.getTee()));
					kahvimaara.setText(String.valueOf(uusi.getKahvi()));
					kaakaomaara.setText(String.valueOf(uusi.getKaakao()));

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmLataaAutomaatti_1);
		
		mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmLopeta);
		
		mnTietoja = new JMenu("Tietoja");
		mnTietoja.setForeground(Color.BLACK);
		mnTietoja.setFont(new Font("Arial", Font.BOLD, 16));
		menuBar.add(mnTietoja);
		
		mntmVersiotiedot = new JMenuItem("Versiotiedot");
		mntmVersiotiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot frame = new Versiotiedot();
				frame.setVisible(true);
			}
		});
		mnTietoja.add(mntmVersiotiedot);

	 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		kahvinappi = new JButton("");
		kahvinappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKahvi();
				int maara = ja.getKahvi();
				if(maara<20) {
					kahvimaara.setForeground(Color.RED);
					kahvimaara.setText(String.valueOf(maara));
				}else
				kahvimaara.setText(String.valueOf(maara));
			}
		});
		kahvinappi.setBackground(Color.WHITE);
		kahvinappi.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img/coffee-cup.png")));
		kahvinappi.setBounds(30, 49, 140, 84);
		contentPane.add(kahvinappi);
		
		kaakaonappi = new JButton("");
		kaakaonappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaKaakao();
				int maara = ja.getKaakao();
				if(maara<20) {
					kaakaomaara.setForeground(Color.RED);
					kaakaomaara.setText(String.valueOf(maara));
				}else
				kaakaomaara.setText(String.valueOf(maara));
			}
		});
		kaakaonappi.setBackground(Color.WHITE);
		kaakaonappi.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img/hot-chocolate.png")));
		kaakaonappi.setBounds(30, 340, 140, 86);
		contentPane.add(kaakaonappi);
		
		teenappi = new JButton("");
		teenappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ja.valmistaTee();
				int maara = ja.getTee();
				if(maara<20) {
					teemaara.setForeground(Color.RED);
					teemaara.setText(String.valueOf(maara));
				}else
				teemaara.setText(String.valueOf(maara));
			}
		});
		teenappi.setBackground(Color.WHITE);
		teenappi.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("/img/tea-cup.png")));
		teenappi.setBounds(30, 190, 140, 86);
		contentPane.add(teenappi);
		
		lblKahvi = new JLabel("Kahvi");
		lblKahvi.setFont(new Font("Arial", Font.BOLD, 22));
		lblKahvi.setBounds(69, 131, 86, 49);
		contentPane.add(lblKahvi);
		
		lblTee = new JLabel("Tee");
		lblTee.setFont(new Font("Arial", Font.BOLD, 22));
		lblTee.setBounds(69, 286, 101, 36);
		contentPane.add(lblTee);
		
		lblKaakao = new JLabel("Kaakao");
		lblKaakao.setFont(new Font("Arial", Font.BOLD, 22));
		lblKaakao.setBounds(69, 436, 116, 26);
		contentPane.add(lblKaakao);
		
		
		kahvimaara = new JLabel("50");
		kahvimaara.setFont(new Font("Arial", Font.PLAIN, 22));
		kahvimaara.setBounds(223, 68, 218, 65);
		contentPane.add(kahvimaara);
		
		teemaara = new JLabel("50");
		teemaara.setFont(new Font("Arial", Font.PLAIN, 22));
		teemaara.setBounds(223, 226, 26, 49);
		contentPane.add(teemaara);
		
		kaakaomaara = new JLabel("50");
		kaakaomaara.setFont(new Font("Arial", Font.PLAIN, 22));
		kaakaomaara.setBounds(223, 365, 36, 65);
		contentPane.add(kaakaomaara);
		
		lblKahvia = new JLabel("Kahvia:");
		lblKahvia.setFont(new Font("Arial", Font.PLAIN, 20));
		lblKahvia.setBounds(223, 49, 150, 26);
		contentPane.add(lblKahvia);
		
		lblTeet = new JLabel("Teetä:");
		lblTeet.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTeet.setBounds(223, 190, 121, 26);
		contentPane.add(lblTeet);
		
		lblKaakaota = new JLabel("Kaakaota:");
		lblKaakaota.setFont(new Font("Arial", Font.PLAIN, 20));
		lblKaakaota.setBounds(223, 340, 121, 36);
		contentPane.add(lblKaakaota);
	}
}
