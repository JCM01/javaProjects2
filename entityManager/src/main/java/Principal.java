
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Animal;
import model.Familia;

public class Principal {
	
	private static Scanner lector;
	
	static EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Evidencia1-2t");
	static EntityManager em = factoria.createEntityManager();

	public static void main(String[] args) throws ClassNotFoundException {
		
		String opc="";
		lector = new Scanner(System.in);
		
		do {
			System.out.println("1. Listado con todas las familias de animales");
			System.out.println("2. Listado de animales a la familia que pertenecen");
			System.out.println("3. Busqueda de familia por id y mostrar animales de familia");
			System.out.println("4. Añadir una nueva familia");
			System.out.println("5. Fin programa.");
			System.out.println("Que opcion eliges del 1 al 5");
			opc = lector.nextLine();
			switch (opc) {
			case "1":
				opcion1();
				break;
			case "2":
				opcion2();
				break;
			case "3":
				opcion3();
				break;
			case "4":
				opcion4();
				break;
			case "5":
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		}while (!opc.equals("5"));
		
		lector.close();
		
}

	private static void opcion1(){
		
		TypedQuery<Familia> query = em.createNamedQuery("Familia.findAll", Familia.class);
		List<Familia> familiaToda = query.getResultList();

		for (Familia fa : familiaToda) {
			System.out.println(fa.getFamilia());
		}

	
	}
	
	private static void opcion2(){
	
		TypedQuery<Animal> query2 = em.createNamedQuery("Animal.findAll", Animal.class);
		List<Animal> animalTodos = query2.getResultList();
		
		for (Animal an : animalTodos) {
			System.out.println(an.getAnimal()+"-"+ an.getFamilia().getFamilia());
		}
		
	}
	
	private static void opcion3(){
		/*
		System.out.println("Dime el id: ");
		int id = lector.nextInt();
		lector.nextLine();
		Familia fa2 = em.find(Familia.class, id);
				
		System.out.println(fa2.getAnimals()); 
				
		*/
		
		
	}
	
	private static void opcion4(){
		
		
	}
		
	
}
	