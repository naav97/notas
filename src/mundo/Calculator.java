package mundo;

import java.io.FileWriter;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	
	public void removeClase(int i) {
		clases.remove(i);
	}
	
	public void save() throws Exception {
		JSONObject obj = new JSONObject();
		for(Clase c : clases) {
			obj.put("nombre", c.getNombre());
			JSONArray notas = new JSONArray();
			for(Nota n : c.getNotas()) {
				JSONObject nota = new JSONObject();
				nota.put("nombre", n.getNombre());
				nota.put("porcentage", n.getPorcentage());
				nota.put("puntos", n.getPuntos());
				nota.put("obtenida", n.isObtenida());
				notas.put(nota);
			}
			obj.put("notas", notas);
		}
		
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

}
