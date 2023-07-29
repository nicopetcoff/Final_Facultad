package modelo;

import modelo.Enum.TipoPartido;

public class PartidoPolitico {
	
	private TipoPartido nombrePartido;
	
	public PartidoPolitico(TipoPartido nombrePartido) {
		this.nombrePartido = nombrePartido;
	}
	
	public TipoPartido getNombrePartido() {
		return this.nombrePartido;
	}
	
	

}
