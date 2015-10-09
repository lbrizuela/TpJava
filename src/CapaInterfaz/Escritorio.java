package CapaInterfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
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
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import java.awt.Color;

import javax.swing.JScrollBar;

import java.awt.TextArea;


public class Escritorio extends JFrame {
	

	
    ControladorJuego ctrol;
	private JPanel contentPane;
	private JTextField text_Turno;
	private JTextField text_dniB;
	private JTextField text_dniN;
	private JTextField text_origen;
	private JTextField text_Destino;
	private JTextField textField;
	private JTextArea txaB;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escritorio frame = new Escritorio();
					frame.setVisible(true);
					 frame.setLocationRelativeTo(null);
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
			setBounds(100, 100, 760, 714);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblTurno = new JLabel("Turno ");
			lblTurno.setBounds(22, 187, 46, 14);
			lblTurno.setFont(new Font("Arial", Font.BOLD, 12));
			contentPane.add(lblTurno);
			
			JLabel Blancas = new JLabel("Blancas");
			Blancas.setBounds(22, 222, 81, 14);
			Blancas.setFont(new Font("Arial", Font.BOLD, 12));
			contentPane.add(Blancas);
			
			JLabel lblOrigen = new JLabel("Origen");
			lblOrigen.setBounds(252, 238, 46, 14);
			lblOrigen.setFont(new Font("Arial", Font.BOLD, 12));
			contentPane.add(lblOrigen);
			
			JLabel lblDestino = new JLabel("Destino");
			lblDestino.setBounds(252, 294, 46, 14);
			lblDestino.setFont(new Font("Arial", Font.BOLD, 12));
			contentPane.add(lblDestino);
			
			JButton btnMover = new JButton("Mover");
			btnMover.setBounds(252, 359, 147, 23);
			btnMover.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					mover();
				}
			});
			btnMover.setFont(new Font("Arial", Font.BOLD, 12));
			contentPane.add(btnMover);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(438, 187, 289, 288);
			lblNewLabel.setIcon(new ImageIcon(Escritorio.class.getResource("/Imagenes/ajedrez.jpg")));
			contentPane.add(lblNewLabel);
			
			text_Turno = new JTextField();
			text_Turno.setBounds(73, 185, 128, 20);
			text_Turno.setEnabled(false);
			contentPane.add(text_Turno);
			text_Turno.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Negras");
			lblNewLabel_1.setBounds(22, 495, 46, 14);
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
			contentPane.add(lblNewLabel_1);
			
			text_origen = new JTextField();
			text_origen.setBounds(252, 263, 147, 20);
			text_origen.setText("Posici\u00F3n origen");
			text_origen.setHorizontalAlignment(SwingConstants.CENTER);
			text_origen.setFont(new Font("Arial", Font.ITALIC, 10));
			contentPane.add(text_origen);
			text_origen.setColumns(10);
			
			text_Destino = new JTextField();
			text_Destino.setBounds(252, 319, 147, 20);
			text_Destino.setHorizontalAlignment(SwingConstants.CENTER);
			text_Destino.setText("Posici\u00F3n destino");
			text_Destino.setFont(new Font("Arial", Font.ITALIC, 10));
			contentPane.add(text_Destino);
			text_Destino.setColumns(10);
		
			
			JPanel panel = new JPanel();
			panel.setBounds(22, 11, 705, 116);
			panel.setBorder(new TitledBorder(null, "Ingrese Dni para Jugar", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
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
					validarPartida();
				}
			});
			btnJugar.setBounds(544, 45, 107, 23);
			panel.add(btnJugar);
			
			JButton bnt_Guardar = new JButton("Guardar Partida");
			bnt_Guardar.setBounds(252, 402, 147, 23);
			bnt_Guardar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					guardarPartida();
				}
			});
			bnt_Guardar.setFont(new Font("Arial", Font.BOLD, 12));
			contentPane.add(bnt_Guardar);
			
			textField = new JTextField();
			textField.setBounds(10, 247, 211, 23);
			contentPane.add(textField);
			textField.setColumns(10);
			
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(217, 590, -183, -1);
			contentPane.add(textArea);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 290, 211, 170);
			contentPane.add(scrollPane);
		
			txaB = new JTextArea();
			scrollPane.setViewportView(txaB);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 511, 211, 154);
			contentPane.add(scrollPane_1);
			
			JTextArea txaN = new JTextArea();
			scrollPane_1.setViewportView(txaN);
			
			
	
	}

	
public void validarPartida() {
	
	///Valida si existe una partida, si no existe la agrega
			Partida p= new Partida();
			ctrol= new ControladorJuego();
			p =ctrol.validarPartida(text_dniB.getText(),text_dniN.getText());// Este metodo si no los encuentras los inicializa ya esta hecho
			if(p==null)
			{
				
				Jugador ju_b= new Jugador();
				Jugador ju_n= new Jugador();
				ju_b=buscarJugador(text_dniB.getText());
				ju_n=buscarJugador(text_dniN.getText());
				p=ctrol.IniciarJuego(ju_b,ju_n);
			}
			mostrarPiezas(p.getPiezas());
}
		
		
		
		private Jugador buscarJugador(String a) {
			
	// TODO Auto-generated method stub
			Jugador jugador=new Jugador();
			jugador=ctrol.existeJugador(a);
			if(jugador==null)
			{
				JOptionPane.showMessageDialog(null, "Jugador blanco debe registrarse");
				CrearJugador cjn=new CrearJugador(this,true);
				cjn.setVisible(true);
				jugador=ctrol.existeJugador(a);
				
			}
	return jugador;
}

	
		private void mostrarPiezas(ArrayList<Pieza>  pieza) {
			// Este metodo muestra las Piezas por patalla
		
			String blancas="";
			String negras="";
			String turno=ctrol.getPartida().getTurno();

		System.out.println("\nEL turno es de:"+turno+"\n");
		System.out.println("Nombre:"+ ctrol.getPartida().getJ_b().getNombre());
		System.out.println("Ubicacione piezas Blancas:"+"\n");
			

		
			for (Pieza p : pieza) {
				  if(p.getColor().equals("blanco")){     
					  if(p.getPosicion()!="")
						  System.out.println("Posicion:"+p.getPosicion()+"->"+"Nombre:"+p.getNombre()+""  );
					  blancas=blancas+p.getPosicion()+ "-"+  p.getNombre()+"\n";
					  
					  ///Aca tampoco me hace el salto de linea, no se si sera por el formato de donde lo muestra, no entiendo mucho 
				  }


				  System.out.println("Ubicacione piezas Negras:"+"\n");
				  for (Pieza p1 : pieza) {
					  if(p1.getColor().equals("negro")){
						  if(p1.getPosicion()!="")
							  System.out.println("Posicion:"+p1.getPosicion()+"->"+"Nombre:"+p1.getNombre()+""  );
						  negras=negras+p1.getPosicion()+"-"+p1.getNombre()+" \n"; 
					  }
					
				  }
					System.out.println(blancas);
					textField.setText(blancas);
					txaB.setText(blancas);
					txaN.
					//textFieldn.setText(negras);
					text_Turno.setText(turno);
				  }
		}

			

		
			

		

		
		
		public void mover()
		
		{
			//Este metodo mueve la ficha
			
			Partida p=new Partida();
			boolean respuesta=ctrol.validarMovimiento( text_origen.getText(), text_Destino.getText());
			if (respuesta==false){
				JOptionPane.showMessageDialog(null, "Movimiento Incorrecto");
				text_origen.setText(null);
				text_Destino.setText(null);
				mostrarPiezas(p.getPiezas());
				
				}else{
					JOptionPane.showMessageDialog(null,"Movimiento Correcto");
					p=ctrol.realizarMovimiento(text_origen.getText(), text_Destino.getText()); //// este metodo realiza el movimiento
					if(p.isJuegoGanado())
					{
						finalizarJugo();
					}
					else
					{
						ctrol.cambiarTurno();
						mostrarPiezas(p.getPiezas());
					}
					text_origen.setText(null);
					text_Destino.setText(null);
					
					
					
				}
				}
			
			
			
			
		
				
			
			

	private void limpiar() {
		//Este metodo limpia la interfaz
			text_origen.setText(null);
			text_Destino.setText(null);
			//text_b.setText(null);
			//text_n.setText(null);
			textField.setText(null);
			//textFieldn.setText(null);
			text_dniB.setText(null);
			text_dniN.setText(null);
			text_Turno.setText(null);
			
			
			
		}

	private void finalizarJugo() {
		//Este metodo muestra que un jugador gano, y borra la partida llamando al controlador
		    JOptionPane.showMessageDialog(null, "Gano el jugador: "+ctrol.getPartida().getTurno());
		    limpiar();
			ctrol.borrarPartida();
			
			
		}
	
private void guardarPartida() {
	//Este metodo llama al controlador para Guardar todos los datos.
	ctrol.UpPartida();
	JOptionPane.showMessageDialog(null,"Se ha guardado con exito");
	limpiar();
	
	
	
}
}
