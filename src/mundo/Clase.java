package mundo;

import java.util.ArrayList;
import java.util.Collections;

import Persist.ClasePersist;
import Persist.NotaPersist;

public class Clase {
	
	int id;
	private String nombre;
	ArrayList<Nota> notas;
	
	public Clase(int id, String pNombre) {
		this.nombre = pNombre;
		this.id = id;
		notas = new ArrayList<>();
	}
	
	public Clase(int id, String pNombre, ArrayList<Nota> nnotas) {
		this.nombre = pNombre;
		this.id = id;
		notas = nnotas;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}
	
	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public void addNota(Nota n) {
		notas.add(n);
	}
	
	public void removeNota(Nota n) {
		notas.remove(n);
	}
	
	public void removeNota(int n) {
		notas.remove(n);
	}
	
	public double getDefinitiva() {
		double re = 0;
		for(Nota n : notas) {
			re = re + n.getNota();
		}
		return re;
	}
	
	private boolean checkPaso(ArrayList<Nota> ns, double num) {
		double def = 0;
		for(Nota n : ns) {
			def = def + n.getNota();
		}
		if(def < num * 100) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private boolean checkNoObtenidaExiste(ArrayList<Nota> ns) {
		boolean re = false;
		for(Nota n : ns) {
			if(!n.isObtenida()) {
				re = true;
				break;
			}
		}
		return re;
	}
	
	public ArrayList<Nota> notasQueTocaSacar(double num){
		ArrayList<Nota> re = new ArrayList<>();
		for(Nota n : notas) {
			String ob;
			if(n.isObtenida()) {
				ob = "Y";
			}
			else {
				ob = "N";
			}
			re.add(new Nota(n.getId(),n.getNombre(),n.getPorcentage(),n.getPuntos(),ob,n.getIDClase()));
		}
		boolean ya = false;
		boolean Noobtenidas = checkNoObtenidaExiste(re);
		if(Noobtenidas) {
			while(!ya) {
				if(checkPaso(re,num)) {
					ya = true;
				}
				for(Nota n : re) {
					if(!n.isObtenida()) {
						n.setPuntos(n.getPuntos() + 0.1);
					}
					if(checkPaso(re,num)) {
						ya = true;
						break;
					}
				}
			}
		}
		return re;
	}

}
