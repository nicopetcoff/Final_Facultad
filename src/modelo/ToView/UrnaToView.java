package modelo.ToView;

import java.util.ArrayList;

import modelo.MesaElectoral;
import modelo.Voto;
import modelo.Enum.TipoUrna;

public class UrnaToView {	


	private TipoUrna tipoUrna;
	private int mesa;
	private int numero;
	

	public UrnaToView(TipoUrna tipoUrna, int mesa, int numero) {

		this.tipoUrna = tipoUrna;
		this.mesa = mesa;
		this.numero = numero;
	}


	public TipoUrna getTipoUrna() {
		return tipoUrna;
	}


	public int getMesa() {
		return mesa;
	}


	public int getNumero() {
		return numero;
	}
	
	

}
