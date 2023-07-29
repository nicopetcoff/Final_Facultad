package modelo;

import modelo.ToView.FiscalToView;

public class Fiscal extends PersonaElectoral{

	public Fiscal(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
		
	}
	
	public FiscalToView toView() {
		return (new FiscalToView(this.nombre, this.apellido, this.dni));
	}

	public String getDNI() {
		return this.dni;
	}

}
