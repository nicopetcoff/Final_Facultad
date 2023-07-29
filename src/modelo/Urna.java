package modelo;

import java.util.ArrayList;

import modelo.Enum.TipoPartido;
import modelo.Enum.TipoUrna;
import modelo.Exception.NoEsConvencionalException;
import modelo.Exception.NoEsElectronicaException;
import modelo.ToView.UrnaToView;

public class Urna {

	private TipoUrna tipoUrna;
	private int nroMesa;
	private int numero;
	private static int numeroSiguiente = 1;
	private ArrayList<Voto> votos;
	private String firmaUrna;

	public Urna(TipoUrna tipoUrna, int mesa) {

		this.tipoUrna = tipoUrna;
		this.nroMesa = mesa;
		this.numero = numeroSiguiente;
		numeroSiguiente++;
		this.votos = new ArrayList<>();
	}
	
	public UrnaToView toView() {
		return (new UrnaToView(this.tipoUrna, this.nroMesa, this.numero));
	}

	public void cargarVoto(Voto voto2) {
		
		Voto voto3 = new Voto(voto2.getPartido());
		
		this.votos.add(voto3);
		
	}
	

	public int cantidadVotos(PartidoPolitico partidoPolitico) {

		int cantidadVotos = 0;

		for (Voto voto : votos) {
			if (voto.getPartido().equals(partidoPolitico)) {
				cantidadVotos++;
			}
		}

		return cantidadVotos;
	}

	public String getFirmaUrnaElectronica() throws NoEsElectronicaException {

		if (this.tipoUrna.equals(TipoUrna.ELECRTONICA)) {

			int votosPartidoRojo = cantidadVotos(new PartidoPolitico(TipoPartido.ROJO));
			int votosPartidoAzul = cantidadVotos(new PartidoPolitico(TipoPartido.AZUL));

			String firmaUrna = "Electronica" + numero + "Cantidad de Votos Rojo" + votosPartidoRojo
					+ "Cantidad de Votos Azul" + votosPartidoAzul;
			
			return firmaUrna;
		}

		throw new NoEsElectronicaException("La urna no es electronica");

	}
	
	public void firmarUrnaConvencional(String firmaUrna) {
		this.firmaUrna = firmaUrna;
	}
	
	public String getFirmaUrnaConvencional() throws NoEsConvencionalException {
		if (this.tipoUrna.equals(TipoUrna.CONVENCIONAL)) {
			return this.firmaUrna;
		}else {
			throw new NoEsConvencionalException("No es urna convencional");
		}
		
		
	}

	public int getCodigo() {
		return this.numero;
	}

	

}
