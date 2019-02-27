package ui;

import java.util.ArrayList;
import java.util.Scanner;

import mundo.*;

public class Ui {
	
	private static Calculator calc;
	
	public static void main(String[] args) throws Exception 
	{
		calc = new Calculator();
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		calc.loadP();
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
			//1C cargar informacion dada
			case 1:
				System.out.println("Escriba el nombre de la clse: ");
				String nombre = sc.next();
				Clase c1 = new Clase(nombre);
				calc.addClase(c1);
				break;
			case 2:
				System.out.println("Escoja una clase: ");
				printMenuClases(calc.getClases());
				int i = sc.nextInt();
				calc.removeClase(i);
				break;
			case 3:
				if(calc.getClases().size() == 0) {
					System.out.println("No hay clases");
					break;
				}
				System.out.println("Escoja una clase: ");
				printMenuClases(calc.getClases());
				int clas = sc.nextInt();
				Clase c3 = calc.getClases().get(clas);
				boolean fin3 = false;
				while(!fin3) {
					printMenuClase(c3);
					String opt3S = sc.next();
					int opt3 = 0;
					if(opt3S.equals("Q")) {
						fin3 = true;
					}
					else {
						opt3 = Integer.parseInt(opt3S);
					}
					switch(opt3) {
					case 1:
						System.out.println("Escriba el nuevo nombre de la clse: ");
						String nombre3 = sc.next();
						c3.setNombre(nombre3);
						break;
					case 2:
						System.out.println("Escriba el nombre de la nota: ");
						String nombreNota = sc.next();
						System.out.println("Escriba el porcentage de la nota: ");
						double porc = sc.nextDouble();
						Nota n32 = new Nota(nombreNota, porc, c3.getNombre());
						c3.addNota(n32);
						break;
					case 3:
						System.out.println("Escoja una nota: ");
						printMenuNotas(c3.getNotas());
						int inot33 = sc.nextInt();
						c3.removeNota(inot33);
						break;
					case 4:
						System.out.println("Escoja una nota: ");
						printMenuNotas(c3.getNotas());
						int nota34 = sc.nextInt();
						Nota n34 = c3.getNotas().get(nota34);
						boolean fin34 = false;
						while(!fin34) {
							printMenuNota(n34);
							String opt34S = sc.next();
							int opt34  = 0;
							if(opt34S.equals("Q")) {
								fin34 = true;
							}
							else {
								opt34 = Integer.parseInt(opt34S);
							}
							switch(opt34) {
							case 1:
								System.out.println("Escriba el nuevo nombre de la nota: ");
								String nombre34 = sc.next();
								n34.setNombre(nombre34);
								break;
							case 2:
								System.out.println("Escriba el nuevo porcentage de la nota: ");
								double porc34 = sc.nextDouble();
								n34.setPorcentage(porc34);
								break;
							case 3:
								System.out.println("Escriba el nuevo puntaje de la nota: ");
								double punt34 =  sc.nextDouble();
								n34.setPuntos(punt34);
								break;
							case 4:
								n34.setObtenida(!n34.isObtenida());
								break;
							}
						}
						break;
					case 5:
						printMenuNotas(c3.getNotas());
						System.out.println("Oprinma Enter para continuar");
						System.in.read();
						break;
					case 6:
						calc.save();
						break;
					case 7:
						System.out.println("Escriba cuanto quiere sacar en la nota final: ");
						double def = sc.nextDouble();
						ArrayList<Nota> notasNes = c3.notasQueTocaSacar(def);
						printMenuNotas(notasNes);
						//calc.reload();
						break;
					}
				}
				break;
			case 4:
				printMenuClases(calc.getClases());
				System.out.println("Oprinma Enter para continuar");
				System.in.read();
				break;
			case 5:
				calc.save();
				break;
			}
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
		System.out.println("5. Guardar");
		System.out.println("Q. Salir");
	}

	private static void printMenuClases(ArrayList<Clase> cs)
	{
		System.out.println("-----------------------NAAV97-------------------------");
		System.out.println("-----------------Calculador de notas------------------");
		System.out.println("Clases: ");
		for(int i = 0; i < cs.size(); i++) {
			System.out.println(i+". "+cs.get(i).getNombre());
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
		System.out.println("6. Guardar");
		System.out.println("7. Calcular Cuanto necesito");
		System.out.println("Q. Salir");
	}
	
	private static void printMenuNotas(ArrayList<Nota> ns) {
		System.out.println("-----------------------NAAV97-------------------------");
		System.out.println("-----------------Calculador de notas------------------");
		System.out.println("Notas: ");
		for(int i = 0; i < ns.size(); i++) {
			Nota nia = ns.get(i);
			System.out.println(i+". "+nia.getNombre()+" "+nia.getPorcentage()+" "+nia.getPuntos()+" "+nia.isObtenida());
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
