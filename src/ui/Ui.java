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

			//opcion req
			int option = sc.nextInt();

			switch(option)
			{
			//1C cargar informacion dada
			case 1:
				String nombre = sc.next();
				//Controller.Controller.adiccionarSuperMercado(nombre);
				break;
			case 2:
				System.out.println("Escriva el tipo de producto (Peresedero, NoPeresedero o Abarrote)");
				String tipo = sc.next();
				if(tipo == "Peresedero") {
					
				}
				else if(tipo == "NoPeresedero") {
					
				}
				else if(tipo == "Abarrote") {
					
				}
				else {
					System.out.println("El tipo de producto "+tipo+" no existe.");
				}
				break;
			case 3:
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
		System.out.println("1. Cargar");
		System.out.println("2. Persistir");
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

}
