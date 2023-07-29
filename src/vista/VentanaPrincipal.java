package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame{
	
	public VentanaPrincipal() {
		super("Menu Principal");
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	setSize(500, 400);

	JPanel panel = new JPanel(new BorderLayout());
	add(panel);

	JLabel titulo = new JLabel("Bienvenido al SistemaElectoral", SwingConstants.CENTER);
	
	panel.add(titulo, BorderLayout.NORTH);
	
	Container cont = new Container();
	cont.setLayout(new FlowLayout());
	panel.add(cont);
	
	JButton urna = new JButton("Ingrese Urna");
	
	cont.add(urna);
	
	urna.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			VentanaUrna ventana = new VentanaUrna();
			ventana.setVisible(true);
		}
	});
		
	//pack();
	}

}
