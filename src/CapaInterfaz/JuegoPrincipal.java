package CapaInterfaz;

import java.awt.BorderLayout;
import CapaDatos.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTextArea;

public class JuegoPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtDniBlancas;
	private JTextField textField;
	CatalogoPartidas cj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoPrincipal frame = new JuegoPrincipal();
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
	public JuegoPrincipal() {
		setTitle("Juego Ajedrez UTN");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JuegoPrincipal.class.getResource("/Imagenes/icon.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosDeJugadores = new JLabel("Datos de Jugadores");
		lblDatosDeJugadores.setBounds(10, 11, 143, 20);
		contentPane.add(lblDatosDeJugadores);
		
		JLabel lblDniBlancas = new JLabel("Dni Blancas:");
		lblDniBlancas.setBounds(10, 42, 94, 14);
		contentPane.add(lblDniBlancas);
		
		JLabel lblDniNegras = new JLabel("Dni Negras:");
		lblDniNegras.setBounds(10, 71, 94, 14);
		contentPane.add(lblDniNegras);
		
		txtDniBlancas = new JTextField();
		txtDniBlancas.setBounds(94, 39, 174, 20);
		contentPane.add(txtDniBlancas);
		txtDniBlancas.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(94, 67, 174, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar Jugadores");
		btnNewButton.setBounds(139, 98, 129, 34);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 169, 258, 82);
		contentPane.add(textArea);
		
		JLabel lblPartidasCargadas = new JLabel("Partidas Cargadas");
		lblPartidasCargadas.setBounds(10, 146, 114, 14);
		contentPane.add(lblPartidasCargadas);
		
		JButton btnContinuarPartida = new JButton("Continuar Partida");
		btnContinuarPartida.setBounds(10, 274, 119, 23);
		contentPane.add(btnContinuarPartida);
		
		JButton btnNewButton_1 = new JButton("Nueva Partida");
		btnNewButton_1.setBounds(149, 274, 119, 23);
		contentPane.add(btnNewButton_1);
	}
}
