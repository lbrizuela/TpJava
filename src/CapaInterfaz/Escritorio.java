package CapaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import capaEntidad.*;
import CapaNegocio.*;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Escritorio extends JFrame {
	ControladorJuego ctrol=new ControladorJuego();;

	private JPanel contentPane;
	private JTextField text_Turno;
	private JTextField text_dniB;
	private JTextField text_dniN;
	private JTextField text_origen;
	private JTextField text_Destino;
	private JTextField text_b;
	private JTextField text_n;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escritorio frame = new Escritorio();
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
	/**
	 * 
	 */
	public Escritorio() {
	
			
			setIconImage(Toolkit.getDefaultToolkit().getImage(Escritorio.class.getResource("/Imagenes/icon.jpg")));
			setTitle("Juego Ajedrez UTN");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 760, 533);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblBlancas = new JLabel("Blancas:");
			lblBlancas.setFont(new Font("Arial", Font.BOLD, 12));
			lblBlancas.setBounds(22, 51, 81, 14);
			contentPane.add(lblBlancas);
			
			JLabel lblNgras = new JLabel("Negras\r\n:");
			lblNgras.setFont(new Font("Arial", Font.BOLD, 12));
			lblNgras.setBounds(22, 95, 81, 14);
			contentPane.add(lblNgras);
			
			
			JButton btnJugar = new JButton("Jugar");
			btnJugar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					validarDni();
				}
			});
			btnJugar.setFont(new Font("Arial", Font.BOLD, 12));
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					validarDni();
				
			
				}
			});
			btnJugar.setBounds(476, 50, 147, 23);
			contentPane.add(btnJugar);
			
			JButton btnGuardar = new JButton("Guardar Partida");
			btnGuardar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					guardarPartida();
				}

				
			});
			btnGuardar.setFont(new Font("Arial", Font.BOLD, 12));
			btnGuardar.setBounds(476, 98, 147, 23);
			contentPane.add(btnGuardar);
			
			JLabel lblTurno = new JLabel("Turno ");
			lblTurno.setFont(new Font("Arial", Font.BOLD, 12));
			lblTurno.setBounds(22, 187, 46, 14);
			contentPane.add(lblTurno);
			
			JLabel Blancas = new JLabel("Blancas");
			Blancas.setFont(new Font("Arial", Font.BOLD, 12));
			Blancas.setBounds(22, 222, 81, 14);
			contentPane.add(Blancas);
			
			JLabel lblOrigen = new JLabel("Origen");
			lblOrigen.setFont(new Font("Arial", Font.BOLD, 12));
			lblOrigen.setBounds(252, 238, 46, 14);
			contentPane.add(lblOrigen);
			
			JLabel lblDestino = new JLabel("Destino");
			lblDestino.setFont(new Font("Arial", Font.BOLD, 12));
			lblDestino.setBounds(252, 294, 46, 14);
			contentPane.add(lblDestino);
			
			JButton btnMover = new JButton("Mover");
			btnMover.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					mover();
				}
			});
			btnMover.setFont(new Font("Arial", Font.BOLD, 12));
			btnMover.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mover();
				}
			});
			btnMover.setBounds(252, 359, 147, 23);
			contentPane.add(btnMover);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Escritorio.class.getResource("/Imagenes/ajedrez.jpg")));
			lblNewLabel.setBounds(449, 187, 278, 297);
			contentPane.add(lblNewLabel);
			
			text_Turno = new JTextField();
			text_Turno.setEnabled(false);
			text_Turno.setBounds(73, 185, 128, 20);
			contentPane.add(text_Turno);
			text_Turno.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Negras");
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
			lblNewLabel_1.setBounds(113, 222, 46, 14);
			contentPane.add(lblNewLabel_1);
			
			text_dniB = new JTextField();
			text_dniB.setHorizontalAlignment(SwingConstants.CENTER);
			text_dniB.setFont(new Font("Arial", Font.ITALIC, 10));
			text_dniB.setBounds(113, 50, 167, 20);
			contentPane.add(text_dniB);
			text_dniB.setColumns(10);
			
			text_dniN = new JTextField();
			text_dniN.setFont(new Font("Arial", Font.PLAIN, 10));
			text_dniN.setHorizontalAlignment(SwingConstants.LEFT);
			text_dniN.setBounds(113, 94, 167, 20);
			contentPane.add(text_dniN);
			text_dniN.setColumns(10);
			
			text_origen = new JTextField();
			text_origen.setText("Posici\u00F3n origen");
			text_origen.setHorizontalAlignment(SwingConstants.CENTER);
			text_origen.setFont(new Font("Arial", Font.ITALIC, 10));
			text_origen.setBounds(252, 263, 147, 20);
			contentPane.add(text_origen);
			text_origen.setColumns(10);
			
			text_Destino = new JTextField();
			text_Destino.setHorizontalAlignment(SwingConstants.CENTER);
			text_Destino.setText("Posici\u00F3n destino");
			text_Destino.setFont(new Font("Arial", Font.ITALIC, 10));
			text_Destino.setBounds(252, 319, 147, 20);
			contentPane.add(text_Destino);
			text_Destino.setColumns(10);
			
			text_b = new JTextField();
			text_b.setBounds(22, 247, 81, 192);
			contentPane.add(text_b);
			text_b.setColumns(10);
			
			text_n = new JTextField();
			text_n.setBounds(113, 247, 86, 192);
			contentPane.add(text_n);
			text_n.setColumns(10);
			
			JLabel lblIngreseDniPara = new JLabel("Ingrese Dni para Jugar");
			lblIngreseDniPara.setFont(new Font("Arial Black", Font.PLAIN, 11));
			lblIngreseDniPara.setBounds(22, 11, 209, 14);
			contentPane.add(lblIngreseDniPara);
			

			
		
			
		}
		private void validarDni() {
			
			ArrayList<Pieza> p= new ArrayList<Pieza>();
			
			p.addAll(ctrol.validarJugador(text_dniB.getText(),text_dniN.getText())); // Este metodo si no los encuentras los inicializa ya esta hecho
			
			mostrarPiezas(p);
		
				
		
		}
		private void mostrarPiezas(ArrayList<Pieza>  pieza) {
			String blancas=null;
			String negras=null;
			String turno=ctrol.getPartida().getTurno();
			for (Pieza p : pieza) {
			  if(p.getColor().equals("blanco"))
				  blancas=p.getPosicion()+"-"+p.getNombre()+"\n";
			  else
				  negras=p.getPosicion()+"-"+p.getNombre()+"\n";
				  
			
			}
			text_b.setText(blancas);
			text_n.setText(negras);
			text_Turno.setText(turno);
			
		}

		

		public void mover()
		{
			
			ArrayList<Pieza> p= new ArrayList<Pieza>();
			boolean respuesta=false;
			while(respuesta==false)
			{
				respuesta=ctrol.realizarMovimiento(text_Turno.getText(), text_origen.getText(), text_Destino.getText());
				/// debe mandar el turno este metodo, asi se valida en las capas superiores
				/// este metodo debe devolver un booleano, si no es correcto itera, deberia mostrar un msj pero no se como se hace.
				
			}
			p.addAll(ctrol.modificarPiezas(text_Turno.getText(), text_origen.getText(), text_Destino.getText()));
			if(p==null)
				finalizarJugo();
			else
				mostrarPiezas(p);
			limpiar();
			
			
			
		}

	private void limpiar() {
			text_origen.setText(null);
			text_Destino.setText(null);
			
		}

	private void finalizarJugo() {
			// TODO Auto-generated method stub
			
		}
	
private void guardarPartida() {
	
	ctrol.UpPartida();
	finalizarJugo();
	
}
}
