package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.SistemaElectoralController;
import modelo.Exception.NoExisteUrnaException;
import modelo.ToView.UrnaToView;

public class VentanaUrna extends JFrame{
	
	SistemaElectoralController controlador = new SistemaElectoralController();
	
	public VentanaUrna() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridLayout(2,2,5,5) );
		
		add(panel);
		
		JLabel urnaLabel = new JLabel("Ingrese Nro Urna");
		JTextField urnaField = new JTextField(10);
		
		JButton aceptar = new JButton("Aceptar");
		
		panel.add(urnaLabel);
		panel.add(urnaField);
		panel.add(aceptar);
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int nroUrna = Integer.parseInt(urnaField.getText());
				
				UrnaToView urna;
				try {
					urna = controlador.buscarUrna(nroUrna);				
					
					VentanaDatosUrna ventana = new VentanaDatosUrna(urna);
					ventana.setVisible(true);
					
					
				} catch (NoExisteUrnaException e1) {
					
					JOptionPane.showMessageDialog(null, "No se pudo", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		
		
		pack();
		
		
	}
	
	

}
