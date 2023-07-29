package modelo;

import java.util.ArrayList;

import modelo.Enum.TipoPartido;
import modelo.Enum.TipoUrna;
import modelo.Exception.NoExisteFiscalException;
import modelo.Exception.NoExisteMesaException;
import modelo.Exception.NoExistePartidoException;
import modelo.Exception.NoExistePresidenteException;
import modelo.Exception.NoExisteUrnaException;
import modelo.ToView.UrnaToView;

public class SistemaElectoral {
	
	private static SistemaElectoral instancia;
	
	private ArrayList<MesaElectoral> mesas;
	private ArrayList<Presidente> presidentes;
	private ArrayList<Fiscal> fiscales;
	private ArrayList<PartidoPolitico> partidos;
	
	private SistemaElectoral() {
		
		this.mesas = new ArrayList<>();
		this.presidentes = new ArrayList<>();
		this.fiscales = new ArrayList<>();
		this.partidos = new ArrayList<>();		
		
		
	}
	
	public static SistemaElectoral getInstance() {
		if (instancia == null) {
			instancia = new SistemaElectoral();
		}

		return instancia;
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------
	
	public void crearMesaElectoral(String codigoAlfaMesa, String dniPresidente, String dniFiscal) throws NoExistePresidenteException, NoExisteFiscalException {
		
		Presidente presidente = buscarPresidente (dniPresidente);
		
		Fiscal fiscal = buscarFiscal(dniFiscal);
		
		MesaElectoral mesa = new MesaElectoral(codigoAlfaMesa, presidente, fiscal);
		
		mesas.add(mesa);
	}
	
	public void agregarUrnaMesa(String codigoMesa, String tipoUrna1) throws NoExisteMesaException, NoExisteUrnaException {
		
		MesaElectoral mesa = buscarMesa(codigoMesa);
		TipoUrna tipoUrna = buscarTipoUrna(tipoUrna1);
		
		mesa.agregarUrna(tipoUrna);
	}
	
	public void agregarVoto(String codigoMesa, int codigoUrna, String voto) throws NoExisteMesaException, NoExisteUrnaException, NoExistePartidoException {
		
		MesaElectoral mesa = buscarMesa(codigoMesa);
		TipoPartido tipo = buscarTipoPartidoPolitico(voto);
		
		PartidoPolitico partido = buscarPartido(tipo);
		
		
		mesa.agregarVoto(codigoUrna, partido);
		
	}
	
	public int contarVotos(String codigoMesa, int codigoUrna, String partidoPol) throws NoExisteMesaException, NoExistePartidoException, NoExisteUrnaException {
		
		MesaElectoral mesa = buscarMesa(codigoMesa);
		
		TipoPartido tipo = buscarTipoPartidoPolitico(partidoPol);
		
		PartidoPolitico partido = buscarPartido(tipo);
		
		
		
		return mesa.contarVotos(codigoUrna, partido);
		
	}
	

	public UrnaToView getUrna(int nroUrna) throws NoExisteUrnaException {
		
		for(MesaElectoral mesa : mesas) {
			if(mesa.tengoEsaUrna(nroUrna))
				return mesa.dameUrnaToView(nroUrna);
		}
		
		throw new NoExisteUrnaException("No existe la urna");
	}

	public void agregarMesa(MesaElectoral mesa) {
		this.mesas.add(mesa);
	}
	
	
	


	//-----------------------------------------------------------------------------------------------------------------------------------
	
	private TipoUrna buscarTipoUrna(String tipoUrna1) throws NoExisteUrnaException {
		
		TipoUrna[] urnas = TipoUrna.values();
		
		for(TipoUrna urna : urnas) {
			if(urna.name().equals(tipoUrna1)) {
				return urna;
			}
		}
		
		throw new NoExisteUrnaException("No existe la Urna");
	}
	
	private TipoPartido buscarTipoPartidoPolitico(String tipoPartido1) throws NoExistePartidoException {
		
		TipoPartido[] tipos = TipoPartido.values();
		
		for(TipoPartido tipo : tipos) {
			if(tipo.name().equals(tipoPartido1)) {
				return tipo;
			}
		}
		throw new NoExistePartidoException("No existe la Urna");
	}

	private Presidente buscarPresidente(String dniPresidente) throws NoExistePresidenteException {
		
		for(Presidente presidente : presidentes) {
			if(presidente.getDNI().equals(dniPresidente)) {
				return presidente;
			}
		}
		throw new NoExistePresidenteException("No existe el Presidente");		
		
	}
	
	private Fiscal buscarFiscal(String dniFiscal) throws NoExisteFiscalException{
		for(Fiscal fiscal : fiscales) {
			if(fiscal.getDNI().equals(dniFiscal)) {
				return fiscal;
			}
		}
		
		throw new NoExisteFiscalException("No existe el Fiscal");
	}
	
	private MesaElectoral buscarMesa(String codigoMesa) throws NoExisteMesaException{
		
		for(MesaElectoral mesa : mesas) {
			if(mesa.getCodigo().equals(codigoMesa)) {
				return mesa;
			}
		}
		
		throw new NoExisteMesaException("No existe la mesa");
		
	}
	
	private PartidoPolitico buscarPartido(TipoPartido tipoPartido) throws NoExistePartidoException {
		for(PartidoPolitico partido : partidos) {
			if(partido.getNombrePartido().equals(tipoPartido)) {
				return partido;
			}
		}
		
		throw new NoExistePartidoException("No existe el partido");
	}

	
	
	

}
