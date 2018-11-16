package ui;

import java.util.ArrayList;
import java.util.Scanner;

import mundo.*;

public class Ui {
	
	private static Calculator calc;
	
	public static void main(String[] args) 
	{
		calc = new Calculator();
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		while(!fin)
		{
			printMenuPrincipal();
			//opcion req
			int option = sc.nextInt();

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
				System.out.println("Escoja una clase: ");
				printMenuClases(calc.getClases());
				int clas = sc.nextInt();
				Clase c3 = calc.getClases().get(clas);
				boolean fin3 = false;
				while(!fin) {
					printMenuClase(c3);
					int opt3 = sc.nextInt();
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
						Nota n32 = new Nota(nombreNota, porc);
						c3.addNota(n32);
						break;
					case 3:
						System.out.println("Escoja una nota: ");
						printMenuNotas(c3.getNotas());
						int inot33 = sc.nextInt();
						c3.removeNota(inot33);
						break;
					case 4:
						
						break;
					case 5:
						
						break;
					case 6:
						
						break;
					case 7:
						
						break;
					}
				}
				break;
			case 4:
				
				break;
			case 5:
				
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
		System.out.println("4. Guardar");
		System.out.println("5. Salir");
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
		System.out.println(c.getNombre());
		System.out.println("1. Cambiar nombre");
		System.out.println("2. Agregar Nota");
		System.out.println("3. Eliminar Nota");
		System.out.println("4. Seleccionar Nota");
		System.out.println("5. Mostrar Notas");
		System.out.println("6. Calcular Cuanto necesito");
		System.out.println("7. Salir");
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

}
