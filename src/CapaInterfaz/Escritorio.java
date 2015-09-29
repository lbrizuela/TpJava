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
import javax.swing.JOptionPane;
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

import javax.swing.border.TitledBorder;

import java.awt.Color;


public class Escritorio extends JFrame {
	

	private JPanel contentPane;
	private JTextField text_Turno;
	private JTextField text_dniB;
	private JTextField text_dniN;
	private JTextField text_origen;
	private JTextField text_Destino;
	private JTextField text_b;
	private JTextField text_n;
	private ControladorJuego controlador;
	
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
			btnMover.setFont(new Font("Arial", Font.BOLD, 12));
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
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Ingrese Dni para Jugar", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			panel.setBounds(22, 11, 705, 116);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblBlancas = new JLabel("Blancas:");
			lblBlancas.setBounds(10, 34, 81, 14);
			panel.add(lblBlancas);
			lblBlancas.setFont(new Font("Arial", Font.BOLD, 12));
			
			JLabel lblNgras = new JLabel("Negras\r\n:");
			lblNgras.setBounds(10, 78, 81, 14);
			panel.add(lblNgras);
			lblNgras.setFont(new Font("Arial", Font.BOLD, 12));
			
			text_dniB = new JTextField();
			text_dniB.setBounds(171, 33, 167, 20);
			panel.add(text_dniB);
			text_dniB.setFont(new Font("Arial", Font.PLAIN, 12));
			text_dniB.setColumns(10);
			
			text_dniN = new JTextField();
			text_dniN.setBounds(171, 77, 167, 20);
			panel.add(text_dniN);
			text_dniN.setFont(new Font("Arial", Font.PLAIN, 12));
			text_dniN.setColumns(10);
			
			JButton btnJugar = new JButton("Jugar");
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarDni();
				}
			});
			btnJugar.setBounds(544, 45, 107, 23);
			panel.add(btnJugar);
	
	}

	public void validarDni() {
		// TODO Auto-generated method stub
		controlador= new ControladorJuego();
		try{
			
			Jugador jugB=controlador.validarExistencia(text_dniB.getText());
			
			if (jugB== null){
				JOptionPane.showMessageDialog(null, "Jugador blanco no esta registrado. Debes registrarte para jugar", "Informe", JOptionPane.INFORMATION_MESSAGE);
				CrearJugador cj= new CrearJugador();
				cj.setVisible(true);
				this.setVisible(false);
			
			}else{
				try{
					Jugador jugN= controlador.validarExistencia(text_dniN.getText());
					if(jugN== null){
						JOptionPane.showMessageDialog(null, "Jugador Negro no esta registrado. Debes registrarte para jugar", "Informe", JOptionPane.INFORMATION_MESSAGE);
						CrearJugador cj= new CrearJugador();
						cj.setVisible(true);
						}else{
							if((jugB != null) && (jugN!=null)){
								JOptionPane.showMessageDialog(null, "Ya estan registrados", "Informe", JOptionPane.INFORMATION_MESSAGE);
								//
								//tengo que verificar si los jugadores tienen partidas pendientes
								//
								Partida part= controlador.verificarPartidaExistente(text_dniB.getText(),text_dniN.getText());
								if (part==null){
									//ESTE MESAJE NO IRIA SOLO VERIFICA QUE NO TIENEN PARTIDAS Y SI NO TIENEN LA CREO ENTONCES LA CREO 
									JOptionPane.showMessageDialog(null, "no hay partidas pendientes", "Informe", JOptionPane.INFORMATION_MESSAGE);
									crearNuevaPartida(text_dniB.getText(),text_dniN.getText());
								}else {
									JOptionPane.showMessageDialog(null, "existe una partidas pendientes", "Informe", JOptionPane.INFORMATION_MESSAGE);
									// SI TIENEN UNA PARTIDA PREGUNTAR SI QUIEREN CONTINUAR LA PARTIDA ANTERIOR O HACER UNA NUEVA.
									/// SI HACEN LA ANTERIOR SE TRAE DE LA BASE.
									//// SI QUIEREN UNA NUEVA 
									/* SE ACTUALIZA LA ANTERIOR POR ESTA Y LLAMA AL METODO CREAR PARTIDA) */ 
								}
					
						
						}
				}
			}catch(Exception e){
				
			}
			
		}
	}catch(Exception e){
		
	}
	}

	private void crearNuevaPartida(String dniB, String dniN) {
		// TODO Auto-generated method stub
		controlador.crearNuevaPartida(dniB,dniN);
		
	}


	}



			
		
			
		
	

	
		
			/*
			 
			ArrayList<Pieza> p= new ArrayList<Pieza>();
			
			
			p.addAll(ctrol.validarJugador(text_dniB.getText(),text_dniN.getText())); // Este metodo si no los encuentras los inicializa ya esta hecho
			
			mostrarPiezas(p);
		
		
		
		private void mostrarPiezas(ArrayList<Pieza>  pieza) {
			String blancas=null;
			String negras=null;
			String turno=ctrol.getPartida().getTurno();
			for (Pieza p : pieza) {
			  if(p.getColor().equals("blanco"))     ///If que pregunte si posicion es null, si lo es no la guardo en String DAVID
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
				
				//hace un msj que la respuesta no es correcta, qe el movimiento no es valido. DAVID
			}
			p.addAll(ctrol.modificarPiezas(text_Turno.getText(), text_origen.getText(), text_Destino.getText()));
			///ACA SE PODRIA MOSTRAR SI LA PIEZA FUE COMIDA. 
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
			// DAVID
			
		}
	
private void guardarPartida() {
	
	ctrol.UpPartida();
	finalizarJugo();
	
}
}
*/