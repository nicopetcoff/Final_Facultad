package modelo.ToView;

import modelo.PersonaElectoral;

public class FiscalToView extends PersonaElectoral{

	public FiscalToView(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getDNI() {
		return this.dni;
	}

}
