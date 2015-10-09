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

	private JTextArea textArea_b;
	private JTextArea textArea_n;
	private JTextArea txajuego;
	private JTextField txtNombreJugador;
	private JTextField txtNombreB;
	private JTextField txtNombreN;


	
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
			setBounds(100, 100, 760, 575);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
			
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
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Juego", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(22, 138, 705, 391);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblTurno = new JLabel("Turno ");
			lblTurno.setBounds(289, 31, 46, 14);
			panel_1.add(lblTurno);
			lblTurno.setFont(new Font("Arial", Font.BOLD, 12));
			
			text_Turno = new JTextField();
			text_Turno.setBounds(262, 56, 106, 20);
			panel_1.add(text_Turno);
			text_Turno.setEnabled(false);
			text_Turno.setColumns(10);
			
			JLabel Blancas = new JLabel("Blancas");
			Blancas.setBounds(39, 31, 61, 14);
			panel_1.add(Blancas);
			Blancas.setFont(new Font("Arial", Font.BOLD, 12));
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(20, 82, 93, 267);
			panel_1.add(scrollPane_2);
			
			textArea_b = new JTextArea();
			scrollPane_2.setViewportView(textArea_b);
			
			JLabel lblNewLabel_1 = new JLabel("Negras");
			lblNewLabel_1.setBounds(142, 31, 46, 14);
			panel_1.add(lblNewLabel_1);
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(124, 83, 89, 266);
			panel_1.add(scrollPane);
			
			textArea_n = new JTextArea();
			scrollPane.setViewportView(textArea_n);
			
			JLabel lblOrigen = new JLabel("Origen");
			lblOrigen.setBounds(289, 138, 46, 14);
			panel_1.add(lblOrigen);
			lblOrigen.setFont(new Font("Arial", Font.BOLD, 12));
			
			text_origen = new JTextField();
			text_origen.setBounds(262, 163, 106, 20);
			panel_1.add(text_origen);
			text_origen.setHorizontalAlignment(SwingConstants.CENTER);
			text_origen.setFont(new Font("Arial", Font.ITALIC, 10));
			text_origen.setColumns(10);
			
			JLabel lblDestino = new JLabel("Destino");
			lblDestino.setBounds(289, 196, 46, 14);
			panel_1.add(lblDestino);
			lblDestino.setFont(new Font("Arial", Font.BOLD, 12));
			
			text_Destino = new JTextField();
			text_Destino.setBounds(262, 221, 106, 20);
			panel_1.add(text_Destino);
			text_Destino.setHorizontalAlignment(SwingConstants.CENTER);
			text_Destino.setFont(new Font("Arial", Font.ITALIC, 10));
			text_Destino.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(406, 32, 276, 288);
			panel_1.add(lblNewLabel);
			lblNewLabel.setIcon(new ImageIcon(Escritorio.class.getResource("/Imagenes/ajedrez.jpg")));
			
			JButton btnMover = new JButton("Mover");
			btnMover.setBounds(262, 252, 106, 23);
			panel_1.add(btnMover);
			btnMover.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					mover();
				}
			});
			btnMover.setFont(new Font("Arial", Font.BOLD, 12));
			
			JButton bnt_Guardar = new JButton("Guardar Partida");
			bnt_Guardar.setBounds(406, 346, 129, 23);
			panel_1.add(bnt_Guardar);
			bnt_Guardar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					guardarPartida();
				}
			});
			bnt_Guardar.setFont(new Font("Arial", Font.BOLD, 12));
			
			txtNombreJugador = new JTextField();
			txtNombreJugador.setBounds(262, 107, 108, 20);
			panel_1.add(txtNombreJugador);
			txtNombreJugador.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
			lblNombre.setBounds(289, 82, 61, 14);
			panel_1.add(lblNombre);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					salir();
				}
			});
			btnSalir.setFont(new Font("Arial", Font.BOLD, 12));
			btnSalir.setBounds(553, 346, 129, 23);
			panel_1.add(btnSalir);
			
			txtNombreB = new JTextField();
			txtNombreB.setBounds(20, 56, 93, 20);
			panel_1.add(txtNombreB);
			txtNombreB.setColumns(10);
			
			txtNombreN = new JTextField();
			txtNombreN.setColumns(10);
			txtNombreN.setBounds(128, 56, 85, 20);
			panel_1.add(txtNombreN);
	}
	

protected void salir() {
		// TODO Auto-generated method stub
	   if (JOptionPane.showConfirmDialog(rootPane, "¿Desea realmente salir del Juego?",
               "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
           System.exit(0);
	   guardarPartida();
		
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
				ju_b=buscarJugador(text_dniB.getText(), "Blanco");
				ju_n=buscarJugador(text_dniN.getText(),"Negro");
				p=ctrol.IniciarJuego(ju_b,ju_n);
			}
			mostrarPiezas(p.getPiezas());
}
		
		
		
		private Jugador buscarJugador(String a, String b) {
			
	// TODO Auto-generated method stub
			Jugador jugador=new Jugador();
			jugador=ctrol.existeJugador(a);
			if(jugador==null)
			{
				JOptionPane.showMessageDialog(null, "Jugador"+ b +" debe registrarse");
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
			String jugadorB= ctrol.getPartida().getJ_b().getNombre();
			String jugadorN=ctrol.getPartida().getJ_n().getNombre();
			
				
			for (Pieza p : pieza) {
				  if(p.getColor().equals("blanco")){     
					  if(!p.getPosicion().equals("comido"))
					  blancas=blancas+p.getPosicion()+ "-"+  p.getNombre()+"\n";

				  }
				  else
				  {
						  if(!p.getPosicion().equals("comido"))
						  negras=negras+p.getPosicion()+"-"+p.getNombre()+" \n"; 
					  }
					
				  
					
					
				  }			
					textArea_b.setText(blancas);
					text_Turno.setText(turno);
					if (turno.equals("blanco")) {
						txtNombreJugador.setText(jugadorB);
						
					}else {
						txtNombreJugador.setText(jugadorN);
					}
					
					textArea_b .setText(blancas);
					textArea_n.setText(negras);
					text_Turno.setText(turno);
					txtNombreB.setText(jugadorB);
					txtNombreN.setText(jugadorN);

				  }

			
		public void mover()
		
		{
			//Este metodo mueve la ficha
			
			
			boolean respuesta=ctrol.validarMovimiento( text_origen.getText(), text_Destino.getText());
			if (respuesta==false){
				JOptionPane.showMessageDialog(null, "Movimiento Incorrecto");
				text_origen.setText(null);
				text_Destino.setText(null);
				mostrarPiezas(ctrol.getPartida().getPiezas());
				
				}else{
					JOptionPane.showMessageDialog(null,"Movimiento Correcto");
					ctrol.realizarMovimiento(text_origen.getText(), text_Destino.getText()); //// este metodo realiza el movimiento
					if(ctrol.getPartida().isJuegoGanado())
					{
						finalizarJugo();
					}
					else
					{
						ctrol.cambiarTurno();
						text_origen.setText(null);
						text_Destino.setText(null);
						mostrarPiezas(ctrol.getPartida().getPiezas());
					}
					
					
					
					
				}
				}
			

	private void limpiar () {
		//Este metodo limpia la interfaz
			
	    	text_origen.setText(null);
			text_Destino.setText(null);

			//text_b.setText(null);
			//text_n.setText(null);
			
			//textFieldn.setText(null);

			textArea_b .setText(null);
			textArea_n.setText(null);

			text_dniB.setText(null);
			text_dniN.setText(null);
			text_Turno.setText(null);
			txtNombreJugador.setText(null);
	
		}

	private void finalizarJugo() {
		//Este metodo muestra que un jugador gano, y borra la partida llamando al controlador.
		
		    JOptionPane.showMessageDialog(null, "Gano el jugador: "+ctrol.getPartida().getTurno());
		    limpiar();
			ctrol.borrarPartida();
			
			
		}
	
private void guardarPartida() {
	//Este metodo llama al controlador para Guardar todos los datos.
	
	ctrol.UpPartida();
	JOptionPane.showMessageDialog(null,"La partida se ha guardado con Éxito");
	//limpiar(); aca capaz que no la limpie y que solo la guarde por las dudas si qyieren seguir jugaando
	
	
	
}
}
