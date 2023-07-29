package controlador;

import modelo.SistemaElectoral;
import modelo.Exception.NoExisteUrnaException;
import modelo.ToView.UrnaToView;

public class SistemaElectoralController {
	
	private SistemaElectoral sistema;
	
	public SistemaElectoralController() {
		sistema = SistemaElectoral.getInstance(); 
	}

	public UrnaToView buscarUrna(int nroUrna) throws NoExisteUrnaException {
		
		return sistema.getUrna(nroUrna);
	}
	
	   
	
	

}
