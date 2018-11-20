package mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.*;

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
	
	private String leerJson() throws Exception {
		StringBuffer fileData = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader("Data.json"));
		char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
	}
	
	public void load() throws Exception {
		String data = leerJson();
		JSONObject obj = new JSONObject(data);
		JSONArray clasesj = (JSONArray) obj.get("clases");
		for(int i = 0; i < clasesj.length(); i++) {
			Clase c = new Clase(clasesj.getJSONObject(i).getString("nombre"));
			ArrayList<Nota> nostasRe = new ArrayList<>();
			JSONArray notasj = clasesj.getJSONObject(i).getJSONArray("notas");
			for(int j = 0; j < notasj.length(); j++) {
				Nota n = new Nota(notasj.getJSONObject(j).getString("nombre"), notasj.getJSONObject(j).getDouble("porcentage"), notasj.getJSONObject(j).getDouble("puntos"), notasj.getJSONObject(j).getBoolean("obtenida"));
				nostasRe.add(n);
			}
			c.setNotas(nostasRe);
			this.clases.add(c);
		}
	}
	
	public void reload() throws Exception {
		clases = null;
		clases = new ArrayList<>();
		load();
	}

}
