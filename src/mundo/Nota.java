package mundo;

public class Nota {
	
	int id;
	private String nombre;
	private double porcentage;
	private double puntos;
	private boolean obtenida;
	private int idClase;
	
	public Nota(String pNombre, double pPorcentage, int pIDClase) {
		this.nombre = pNombre;
		this.porcentage = pPorcentage;
		this.puntos = 0;
		this.obtenida = false;
		this.idClase = pIDClase;
	}
	
	public Nota(int id, String pNombre, double pPorcentage, double pPuntos, String pObtenida, int pIDClase) {
		this.id = id;
		this.nombre = pNombre;
		this.porcentage = pPorcentage;
		this.puntos = pPuntos;
		if(pObtenida == "Y") {
			this.obtenida = true;
		}
		else {
			this.obtenida = false;
		}
		this.idClase = pIDClase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPorcentage() {
		return porcentage;
	}

	public void setPorcentage(double porcentage) {
		this.porcentage = porcentage;
	}

	public double getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}
	
	public boolean isObtenida() {
		return obtenida;
	}

	public void setObtenida(boolean obtenida) {
		this.obtenida = obtenida;
	}

	public double getNota() {
		return porcentage * puntos;
	}
	
	public int getIDClase() {
		return this.idClase;
	}

}
