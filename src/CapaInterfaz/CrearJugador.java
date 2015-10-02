package CapaInterfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Panel;

import CapaNegocio.ControladorJuego;

import capaEntidad.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearJugador extends JFrame {

///Luisina
//Alfo
	private JPanel contentPane;
	private JTextField txtRdni;
	private JTextField txtRnombre;
	private JTextField txtRapellido;
	private ControladorJuego controlador;
	
	public CrearJugador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearJugador.class.getResource("/Imagenes/icon.jpg")));
		setTitle("Registrar Jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel nuevoJugador = new JPanel();
		nuevoJugador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registrar nuevo jugador:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		nuevoJugador.setBounds(10, 11, 425, 160);
		contentPane.add(nuevoJugador);
		nuevoJugador.setLayout(null);
		

		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(10, 44, 46, 14);
		nuevoJugador.add(lblDni);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 85, 46, 14);
		nuevoJugador.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 124, 46, 14);
		nuevoJugador.add(lblApellido);
		
		txtRdni = new JTextField();
		txtRdni.setBounds(109, 41, 116, 20);
		nuevoJugador.add(txtRdni);
		txtRdni.setColumns(10);
		
		txtRnombre = new JTextField();
		txtRnombre.setBounds(109, 82, 116, 20);
		nuevoJugador.add(txtRnombre);
		txtRnombre.setColumns(10);
		
		txtRapellido = new JTextField();
		txtRapellido.setColumns(10);
		txtRapellido.setBounds(109, 121, 116, 20);
		nuevoJugador.add(txtRapellido);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarj();
			}
		});
		btnRegistrar.setBounds(299, 67, 89, 23);
		nuevoJugador.add(btnRegistrar);
	}

	protected void registrarj() {
		// TODO Auto-generated method stub
		controlador = new ControladorJuego();
		Jugador j =this.mapearDeDatos();
		controlador.save(j);
		JOptionPane.showMessageDialog(null, "Se ha registrado con éxito", "Informe", JOptionPane.INFORMATION_MESSAGE);
		this.setVisible(false);
	
		
	}

	private Jugador mapearDeDatos() {
		// TODO Auto-generated method stub
		Jugador j = new Jugador();
		j.setDni(txtRdni.getText());
		j.setNombre(txtRnombre.getText());
		j.setApellido(txtRapellido.getText());
		return j;
	}
}
