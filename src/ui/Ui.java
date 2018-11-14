package ui;

import java.util.ArrayList;
import java.util.Scanner;

import mundo.*;

public class Ui {
	
	private static Calculator calc;
	
	public static void main(String[] args) 
	{
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
				Clase c = new Clase(nombre);
				calc.addClase(c);
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
				break;
			case 4:
				System.out.println("Ingrese el nombre");
				String nombreSucursal = sc.next();
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
	}

}
