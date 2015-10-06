package CapaInterfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import CapaNegocio.ControladorJuego;
import capaEntidad.Jugador;



public class CrearJugador extends JDialog {


		private final JPanel contentPanel = new JPanel();
		private JTextField txtRdni;
		private JTextField txtRnombre;
		private JTextField txtRapellido;

		public CrearJugador (Escritorio escritorio, boolean modal){
			super(escritorio, modal);
			
			setBounds(100, 100, 450, 218);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registro de Jugador", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			
			JLabel lblDni = new JLabel("Dni:");
			lblDni.setBounds(21, 41, 113, 14);
			contentPanel.add(lblDni);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(21, 78, 113, 14);
			contentPanel.add(lblNombre);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(21, 119, 113, 14);
			contentPanel.add(lblApellido);
			
			txtRdni = new JTextField();
			txtRdni.setBounds(164, 38, 241, 20);
			contentPanel.add(txtRdni);
			txtRdni.setColumns(10);
			
			txtRnombre = new JTextField();
			txtRnombre.setBounds(164, 75, 241, 20);
			contentPanel.add(txtRnombre);
			txtRnombre.setColumns(10);
			
			txtRapellido = new JTextField();
			txtRapellido.setBounds(164, 116, 241, 20);
			contentPanel.add(txtRapellido);
			txtRapellido.setColumns(10);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("Registrar");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							registrarJ();
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("Cancelar");
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}

		protected void registrarJ() {
			// TODO Auto-generated method stub
			
			ControladorJuego contJuego= new ControladorJuego();
			Jugador j =this.mapearDatos();
			contJuego.save(j);
			JOptionPane.showMessageDialog(null, "Se ha registrado con éxito", "Informe", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			
		}

		private Jugador mapearDatos() {
			// TODO Auto-generated method stub
			Jugador j = new Jugador();
			j.setDni(txtRdni.getText());
			j.setNombre(txtRnombre.getText());
			j.setApellido(txtRapellido.getText());
			return j;

		}

		

}
