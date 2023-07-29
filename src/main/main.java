package main;

import modelo.*;
import modelo.MesaElectoral;
import modelo.Presidente;
import modelo.Urna;
import modelo.Enum.TipoPartido;
import modelo.Enum.TipoUrna;
import vista.VentanaPrincipal;

public class main {

	public static void main(String[] args) {
		
		SistemaElectoral sistema = SistemaElectoral.getInstance();
		
		Presidente presidente = new Presidente("Nicolas", "Petcoff", "41577536");
		
		Fiscal fiscal = new Fiscal("Carlos", "Peres", "40588999"); 
		
		MesaElectoral mesa = new MesaElectoral("123", presidente, fiscal);
		
		sistema.agregarMesa(mesa);		
		
		Urna urna1  = mesa.agregarUrna(TipoUrna.ELECRTONICA);		
		
		Urna urna2 = mesa.agregarUrna(TipoUrna.ELECRTONICA);
		
		
		PartidoPolitico partidoRojo = new PartidoPolitico(TipoPartido.ROJO);
		
		PartidoPolitico partidoAzul = new PartidoPolitico(TipoPartido.AZUL);
		
		
		Voto votoRojo = new Voto(partidoRojo);
		
		Voto votoAzul = new Voto(partidoAzul);
		
		
		
		
		
		urna1.cargarVoto(votoRojo);		
		urna1.cargarVoto(votoRojo);
		urna1.cargarVoto(votoRojo);
		urna1.cargarVoto(votoAzul);
		urna1.cargarVoto(votoAzul);
		
		urna2.cargarVoto(votoRojo);		
		urna2.cargarVoto(votoAzul);
		urna2.cargarVoto(votoAzul);
		urna2.cargarVoto(votoAzul);
		urna2.cargarVoto(votoAzul);		
		
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
		
		
		

	}

}
