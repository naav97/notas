package mundo;

import java.util.ArrayList;

public class Clase {
	
	private String nombre;
	private ArrayList<Nota> notas;
	
	public Clase(String pNombre) {
		this.nombre = pNombre;
		this.notas = new ArrayList<>();
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
		if(def < num) {
			return false;
		}
		else {
			return true;
		}
	}
	
	private void aumentarUna(ArrayList<Nota> ns) {
		for(Nota n : ns) {
			if(!n.isObtenida()) {
				n.setPuntos(n.getPuntos() + 0.1);
			}
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
			re.add(n);
		}
		boolean ya = false;
		while(!ya) {
			if(checkPaso(re,num)) {
				ya = true;
			}
			if(checkNoObtenidaExiste(re)) {
				aumentarUna(re);
			}
			else {
				ya = true;
			}
		}
		return re;
	}

}
