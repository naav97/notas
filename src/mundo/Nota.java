package mundo;

public class Nota {
	
	private String nombre;
	private double porcentage;
	private double puntos;
	private boolean obtenida;
	
	public Nota(String pNombre, double pPorcentage) {
		this.nombre = pNombre;
		this.porcentage = pPorcentage;
		this.puntos = 0;
		this.obtenida = false;
	}
	
	public Nota(String pNombre, double pPorcentage, double pPuntos, boolean pObtenida) {
		this.nombre = pNombre;
		this.porcentage = pPorcentage;
		this.puntos = pPuntos;
		this.obtenida = pObtenida;
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

}
