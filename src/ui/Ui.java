package ui;

import java.util.ArrayList;
import java.util.Scanner;

import logic.ClaseLogic;
import logic.NotaLogic;
import mundo.*;

public class Ui {
	
	private static ClaseLogic cl;
	private static NotaLogic nl;
	private static ArrayList<Clase> clases;
	private static ArrayList<Nota> notas;
	
	public static void main(String[] args) throws Exception 
	{
		cl = new ClaseLogic();
		nl = new NotaLogic();
		load();
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		while(!fin)
		{
			printMenuPrincipal();
			//opcion req
			String opt = sc.next();
			int option = 0;
			if(opt.equals("Q")) {
				fin = true;
			}
			else {
				option = Integer.parseInt(opt);
			}

			switch(option)
			{
			//1. Agregar Clase
			case 1:
				System.out.println("Escriba el nombre de la clse: ");
				String nombre = sc.next();
				cl.createClase(nombre);
				break;
			//2. Eliminar Clase
			case 2:
				System.out.println("Escoja una clase: ");
				printMenuClases(cl.darClases());
				int i = sc.nextInt();
				cl.deleteClase(i);
				break;
			//3. Seleccionar Clase
			case 3:
				if(cl.darClases().size() == 0) {
					System.out.println("No hay clases");
					break;
				}
				System.out.println("Escoja una clase: ");
				printMenuClases(cl.darClases());
				int clas = sc.nextInt();
				boolean fin3 = false;
				while(!fin3) {
					printMenuClase(cl.darClase(clas));
					String opt3S = sc.next();
					int opt3 = 0;
					if(opt3S.equals("Q")) {
						fin3 = true;
					}
					else {
						opt3 = Integer.parseInt(opt3S);
					}
					switch(opt3) {
					//1. Cambiar nombre
					case 1:
						System.out.println("Escriba el nuevo nombre de la clse: ");
						String nombre3 = sc.next();
						cl.updateClase(clas, nombre3);
						break;
					//2. Agregar Nota
					case 2:
						System.out.println("Escriba el nombre de la nota: ");
						String nombreNota = sc.next();
						System.out.println("Escriba el porcentage de la nota: ");
						double porc = sc.nextDouble();
						nl.createNota(nombreNota, porc, clas);
						break;
					//3. Eliminar Nota
					case 3:
						System.out.println("Escoja una nota: ");
						printMenuNotas(nl.darNotasClase(clas));
						int inot33 = sc.nextInt();
						nl.deleteNota(inot33);
						break;
					//4. Seleccionar Nota
					case 4:
						System.out.println("Escoja una nota: ");
						printMenuNotas(nl.darNotasClase(clas));
						int nota34 = sc.nextInt();
						boolean fin34 = false;
						while(!fin34) {
							printMenuNota(nl.darNota(nota34));
							String opt34S = sc.next();
							int opt34  = 0;
							if(opt34S.equals("Q")) {
								fin34 = true;
							}
							else {
								opt34 = Integer.parseInt(opt34S);
							}
							switch(opt34) {
							//1. Cambiar nombre
							case 1:
								System.out.println("Escriba el nuevo nombre de la nota: ");
								String nombre34 = sc.next();
								nl.updateNombre(nota34, nombre34);
								break;
							//2. Cambiar porcentage
							case 2:
								System.out.println("Escriba el nuevo porcentage de la nota: ");
								double porc34 = sc.nextDouble();
								nl.updatePorcentage(nota34, porc34);
								break;
							//3. Cambiar puntos
							case 3:
								System.out.println("Escriba el nuevo puntaje de la nota: ");
								double punt34 =  sc.nextDouble();
								nl.updatePuntos(nota34, punt34);
								break;
							//4. Cambiar obtenida
							case 4:
								Nota n4 = nl.darNota(nota34);
								nl.updateObtenida(nota34, !n4.isObtenida());
								break;
							}
						}
						break;
					//5. Mostrar Notas
					case 5:
						printMenuNotas(nl.darNotasClase(clas));
						System.out.println("Oprinma Enter para continuar");
						System.in.read();
						break;
					//6. Calcular Cuanto necesito
					case 6:
						System.out.println("Escriba cuanto quiere sacar en la nota final: ");
						double def = sc.nextDouble();
						Clase c6 = cl.darClase(clas);
						c6.setNotas(nl.darNotasClase(clas));
						ArrayList<Nota> notasNes = c6.notasQueTocaSacar(def);
						printMenuNotas(notasNes);
						break;
					}
				}
				break;
			//4. Mostrar Clases
			case 4:
				printMenuClases(cl.darClases());
				System.out.println("Oprinma Enter para continuar");
				System.in.read();
				break;
			}
     	}
	}
	
	private static void load() throws Exception {
		clases = cl.darClases();
		notas = nl.darNotas();
		for(Clase c : clases) {
			c.setNotas(nl.darNotasClase(c.getId()));
		}
	}
	
	private static void printMenuPrincipal() {
		System.out.println("-----------------------NAAV97-------------------------");
		System.out.println("-----------------Calculador de notas------------------");
		System.out.println("Menu Principal: ");
		System.out.println("1. Agregar Clase");
		System.out.println("2. Eliminar Clase");
		System.out.println("3. Seleccionar Clase");
		System.out.println("4. Mostrar Clases");
		System.out.println("Q. Salir");
	}

	private static void printMenuClases(ArrayList<Clase> cs)
	{
		System.out.println("-----------------------NAAV97-------------------------");
		System.out.println("-----------------Calculador de notas------------------");
		System.out.println("Clases: ");
		for(int i = 0; i < cs.size(); i++) {
			System.out.println("id: "+cs.get(i).getId()+"| nombre: "+cs.get(i).getNombre());
		}
	}
	
	private static void printMenuClase(Clase c) {
		System.out.println("-----------------------NAAV97-------------------------");
		System.out.println("-----------------Calculador de notas------------------");
		System.out.println(c.getNombre() + " " + c.getDefinitiva());
		System.out.println("1. Cambiar nombre");
		System.out.println("2. Agregar Nota");
		System.out.println("3. Eliminar Nota");
		System.out.println("4. Seleccionar Nota");
		System.out.println("5. Mostrar Notas");
		System.out.println("6. Calcular Cuanto necesito");
		System.out.println("Q. Salir");
	}
	
	private static void printMenuNotas(ArrayList<Nota> ns) {
		System.out.println("-----------------------NAAV97-------------------------");
		System.out.println("-----------------Calculador de notas------------------");
		System.out.println("Notas: ");
		for(int i = 0; i < ns.size(); i++) {
			Nota nia = ns.get(i);
			System.out.println("id: "+nia.getId()+"| "+nia.getNombre()+" "+nia.getPorcentage()+" "+nia.getPuntos()+" "+nia.isObtenida());
		}
	}
	
	private static void printMenuNota(Nota n) {
		System.out.println("-----------------------NAAV97-------------------------");
		System.out.println("-----------------Calculador de notas------------------");
		System.out.println(n.getNombre());
		System.out.println("1. Cambiar nombre");
		System.out.println("2. Cambiar porcentage");
		System.out.println("3. Cambiar puntos");
		System.out.println("4. Cambiar obtenida");
		System.out.println("Q. Salir");
	}

}
