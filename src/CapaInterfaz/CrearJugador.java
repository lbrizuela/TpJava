package CapaInterfaz;

import java.awt.BorderLayout;
import capaEntidad.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearJugador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearJugador frame = new CrearJugador();
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
	public CrearJugador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearJugador.class.getResource("/Imagenes/icon.jpg")));
		setTitle("Registrar Jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrarJugador = new JLabel("Registrar Jugador");
		lblRegistrarJugador.setBounds(10, 30, 90, 14);
		contentPane.add(lblRegistrarJugador);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(10, 68, 99, 14);
		contentPane.add(lblDni);
		
		textField = new JTextField();
		textField.setBounds(127, 65, 172, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 112, 99, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 158, 99, 14);
		contentPane.add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 109, 172, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(127, 155, 172, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				guardarJugador();
				
			}
		});
		btnGuardar.setBounds(207, 206, 89, 23);
		contentPane.add(btnGuardar);
	}
	
	public  Jugador guardarJugador(){ return null;} /// Me tiene que devolver el jugador para que mari lo guarde en la base de dato. DAVId
}
