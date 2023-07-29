package modelo;

import modelo.ToView.PresidenteToView;

public class Presidente extends PersonaElectoral{

	public Presidente(String nombre, String apellido, String dni) {
		super(nombre, apellido, dni);
		
	}
	
	public PresidenteToView toView() {
		
		return (new PresidenteToView(this.nombre, this.apellido, this.dni));
	}

	public String getDNI() {
		return this.dni;
	}
	
	

}
