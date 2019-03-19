package mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.*;

import Persist.ClasePersist;
import Persist.NotaPersist;

public class Calculator {
	
	private ArrayList<Clase> clases;
	private ArrayList<Nota> notas;
	private ClasePersist cp;
	private NotaPersist np;
	
	public Calculator() {
		this.clases = new ArrayList<>();
		this.notas = new ArrayList<>();
		this.cp = new ClasePersist();
		this.np = new NotaPersist();
	}

	public ArrayList<Clase> getClases() {
		return clases;
	}

	public void setClases(ArrayList<Clase> clases) {
		this.clases = clases;
	}
	
	public void addClase(Clase c) throws Exception {
		clases.add(c);
		cp.agregarClase(c.getNombre());
	}
	
	public void removeClase(Clase c) {
		clases.remove(c);
	}
	
	public void removeClase(int i) {
		clases.remove(i);
	}
	
	public void addNota(Nota n) throws Exception {
		Clase c = getClaseNombre(n.getIDClase());
		c.addNota(n);
		np.agregarNota(n);
	}
	
	public Clase getClaseNombre(int nombre) {
		Clase c = null;
		for(Clase cf : clases) {
			if(cf.getId() == nombre) {
				c = cf;
			}
		}
		return c;
	}
	
	public void save() throws Exception {
		JSONObject obj = new JSONObject();
		JSONArray clasesJ = new JSONArray();
		for(Clase c : clases) {
			JSONObject clase = new JSONObject();
			clase.put("nombre", c.getNombre());
			JSONArray notas = new JSONArray();
			for(Nota n : c.getNotas()) {
				JSONObject nota = new JSONObject();
				nota.put("nombre", n.getNombre());
				nota.put("porcentage", n.getPorcentage());
				nota.put("puntos", n.getPuntos());
				nota.put("obtenida", n.isObtenida());
				nota.put("nombreClase", n.getIDClase());
				notas.put(nota);
			}
			clase.put("notas", notas);
			clasesJ.put(clase);
		}
		obj.put("clases", clasesJ);
		
		try {
			FileWriter fw = new FileWriter("Data.json");
			fw.write(obj.toString());
			fw.flush();
			fw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadP() throws Exception {
		this.clases = cp.darClases();
		this.notas = np.darNotas();
	}

}
