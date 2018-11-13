package mundo;

import java.util.ArrayList;

public class Calculator {
	
	private ArrayList<Clase> clases;
	
	public Calculator() {
		this.clases = new ArrayList<>();
	}

	public ArrayList<Clase> getClases() {
		return clases;
	}

	public void setClases(ArrayList<Clase> clases) {
		this.clases = clases;
	}
	
	public void addClase(Clase c) {
		clases.add(c);
	}
	
	public void removeClase(Clase c) {
		clases.remove(c);
	}

}
