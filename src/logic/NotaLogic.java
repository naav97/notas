package logic;

import java.util.ArrayList;

import Persist.ClasePersist;
import Persist.NotaPersist;
import mundo.Nota;

public class NotaLogic {
	
	private NotaPersist np;
	private ClasePersist cp;
	
	public NotaLogic() {
		np = new NotaPersist();
		cp = new ClasePersist();
	}
	
	public void createNota(String nombre, double porcentage, int clase) throws Exception {
		if(nombre == null || nombre == "" || nombre == " ") {
			throw new Exception("El nombre no puede ser nullo");
		}
		if(porcentage < 0 || porcentage > 100) {
			throw new Exception("El porcentage tiene que estar entre 0 y 100");
		}
		if(cp.darClase(clase) == null) {
			throw new Exception("La clase no existe");
		}
		Nota n = new Nota(nombre, porcentage, clase);
		np.agregarNota(n);
	}
	
	public ArrayList<Nota> darNotas() throws Exception {
		return np.darNotas();
	}
	
	public ArrayList<Nota> darNotasClase(int clase) throws Exception {
		if(cp.darClase(clase) == null) {
			throw new Exception("La clase no existe");
		}
		return np.darNotasClase(clase);
	}
	
	public Nota darNota(int nota) throws Exception {
		return np.darNota(nota);
	}

}
