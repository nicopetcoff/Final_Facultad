package vista;

import java.awt.GridLayout;

import javax.swing.*;

import controlador.SistemaElectoralController;
import modelo.Exception.NoExisteUrnaException;
import modelo.ToView.UrnaToView;

public class VentanaDatosUrna extends JFrame{	
	
	public VentanaDatosUrna(UrnaToView urna2){
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridLayout(3,1,5,5));
		add(panel);
		
		JLabel codigoMesa = new JLabel("Nro Mesa" +urna2.getMesa());
		JLabel codigoUrna = new JLabel("Nro Urna" + urna2.getNumero());
		panel.add(codigoMesa);
		panel.add(codigoUrna);
		
		
		pack();
		
		
	}

}
