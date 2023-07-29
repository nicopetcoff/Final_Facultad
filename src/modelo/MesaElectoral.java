package modelo;

import java.util.ArrayList;

import modelo.Enum.TipoUrna;
import modelo.Exception.NoExisteUrnaException;
import modelo.ToView.UrnaToView;

public class MesaElectoral {
	private String codigo;
	private int numeroMesa;
	private static int NumeroSiguiente = 1;
	
	private Presidente presidente;
	private Fiscal fiscal;
	
	private ArrayList<Urna> urnas;
	
	public MesaElectoral(String codigo, Presidente presidente, Fiscal fiscal) {
		
		this.codigo = codigo;
		this.numeroMesa = NumeroSiguiente;
		NumeroSiguiente++;
		this.presidente = presidente;
		this.fiscal = fiscal;
		this.urnas = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public Presidente getPresidente() {
		return presidente;
	}

	public Fiscal getFiscal() {
		return fiscal;
	}
	
	
	public Urna agregarUrna(TipoUrna TipoUrna) {
		
		int codigoalfamesa = Integer.parseInt(codigo);
		
		Urna urna = new Urna(TipoUrna, codigoalfamesa);
		urnas.add(urna);
		
		return urna;
		
	}
	
	public void agregarVoto(int codigoUrna, PartidoPolitico partido) throws NoExisteUrnaException {
		
		Urna urna = buscarUrna(codigoUrna);
		Voto voto = new Voto(partido);
		
		urna.cargarVoto(voto);
		
	}

	private Urna buscarUrna(int codigoUrna) throws NoExisteUrnaException {
		
		for(Urna urna : urnas) {
			if(urna.getCodigo() == codigoUrna){
				return urna;
			}
		}
		throw new NoExisteUrnaException("No existe la urna");
	}

	public int contarVotos(int codigoUrna, PartidoPolitico partido) throws NoExisteUrnaException {
		
		Urna urna = buscarUrna(codigoUrna);
		
		return urna.cantidadVotos(partido);
		
	}

	public boolean tengoEsaUrna(int nroUrna) {
		
		for(Urna urna : urnas) {
			if(urna.getCodigo() == nroUrna) {
				return true;
			}
		}
		return false;
		
	}

	public UrnaToView dameUrnaToView(int nroUrna) {
		
		for(Urna urna : urnas) {
			if(urna.getCodigo() == nroUrna) {
				return urna.toView();
			}
		}
		
		return null;
	}

	public int getNro() {
		return this.numeroMesa;
	}
	
	
	
	
	
	

}
