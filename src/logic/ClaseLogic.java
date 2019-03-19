package logic;

import java.util.ArrayList;

import Persist.ClasePersist;
import mundo.Clase;

public class ClaseLogic {
	
	ClasePersist cp;
	
	public ClaseLogic() {
		cp = new ClasePersist();
	}
	
	public void createClase(String nombre) throws Exception {
		if(nombre == null || nombre == "" || nombre == " ") {
			throw new Exception("El nombre no puede ser nullo");
		}
		cp.agregarClase(nombre);
	}
	
	public ArrayList<Clase> darClases() throws Exception {
		return cp.darClases();
	}
	
	public void updateClase(String nombre, String pNombre) throws Exception {
		if(nombre == null || nombre == "" || nombre == " ") {
			throw new Exception("El nombre no puede ser nullo");
		}
		cp.updateClase(nombre, pNombre);
	}
	
	public void deleteClase(String clase) throws Exception {
		if(cp.darClase(clase) == null) {
			throw new Exception("La clase no existe");
		}
		cp.deleteClase(clase);
	}

}
