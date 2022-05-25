import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Principal {
	
	private static Scanner lector;

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//comprobar si existe el fichero alumno.dat
		// si existe lo recuperamos
		// si no existe creamos un nuevo objeto Alumno
		// El nombre y edad del alumno entran por teclado
		lector = new Scanner(System.in);
		
		
		Alumno alu = recuperarAlumno();
		if(alu==null) {
			System.out.println("Escribe nombre del nuevo alumno ");
			String nombre = lector.nextLine();
			System.out.println("Edad: ");
			int edad = lector.nextInt();
			lector.nextLine();
			alu = new Alumno(nombre, edad);
		}
		
		String opc="";
	
		
	
		do {
			System.out.println("1. Añadir calificación");
			System.out.println("2. Modificar calificación");
			System.out.println("3. Borrar calificacion");
			System.out.println("4. Ver todas las calificaciones");
			System.out.println("5. Ver calificaciones suspensas");
			System.out.println("6. Ver calificaciones aprobadas");
			System.out.println("7. Terminar programa.");
			System.out.println("Que opcion eliges del 1 al 7");
			opc = lector.nextLine();
			switch (opc) {
			case "1":
				System.out.println("Añadir Calificacion");
				opcion1(alu);
				break;
			case "2":
				System.out.println("Modificar Calificacion");
				opcion2(alu);
				break;
			case "3":
				System.out.println("Borrar calificacion");
				opcion3(alu);
				break;
			case "4":
				System.out.println("Ver todas las calificaciones");
				opcion4(alu);
				break;
			case "5":
				System.out.println("Ver calificaciones suspensas");
				opcion5(alu);
				break;
			case "6":
				System.out.println("Ver calificaciones aprobadas");
				opcion6(alu);
				break;
			case "7":
				System.out.println("Fin del programa");
				
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		}while (!opc.equals("7"));
		
		lector.close();
		grabarAlumno(alu);
		//guardar el objeto Alumno
}
	private static void opcion1(Alumno a){
		System.out.println("Nombre de la asignatura ");
		String asig = lector.nextLine();
		System.out.println("Nota obtenida (0-100): ");
		int n = lector.nextInt();
		lector.nextLine(); //limpiar buffer
		a.calificar(asig, n);
	}
	
	private static void opcion2(Alumno a){
		for (Calificacion i : a.getCalificaciones()) {
			System.out.println("Numero de asignaturas que hay: " + a.getCalificaciones().indexOf(i) + " - " + i);
		}
		System.out.println("¿Que asignatura deseas vas a modificar? Pon su indice");
		Scanner sc = new Scanner(System.in);
		int indice = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduzca la nueva calificación");
		int calif = sc.nextInt();
		a.getCalificaciones().get(indice).setNota(calif);
		System.out.println("La calificacion se ha modificado");
		
	}
	
	private static void opcion3(Alumno a){
		for (Calificacion i : a.getCalificaciones()) {
			System.out.println("Numero de asignaturas que hay " + a.getCalificaciones().indexOf(i) + " - " + i);
		}
		System.out.println("¿Cual asignatura borraras? Pon su indice");
		Scanner sc = new Scanner(System.in);
		int indice = sc.nextInt();
		sc.nextLine();
		a.getCalificaciones().remove(indice);
		System.out.println("La calificacion se ha borrado");
	
		
		
	}
	private static void opcion4(Alumno a){
		for(int i=0; i<a.getCalificaciones().size(); i++) {
			System.out.println(a.getCalificaciones().get(i).toString());
		}
	}
		
	private static void opcion5(Alumno a){
		for(int i=0; i<a.getCalificaciones().size(); i++) {
			if(a.getCalificaciones().get(i).getNota()<50) {
				System.out.println(a.getCalificaciones().get(i).toString());
			}
		}
		
	}
	
	private static void opcion6(Alumno a){
		for(int i=0; i<a.getCalificaciones().size(); i++) {
			if(a.getCalificaciones().get(i).getNota()>50) {
				System.out.println(a.getCalificaciones().get(i).toString());
			}
		}
		
	}
	
	private static Alumno recuperarAlumno() throws ClassNotFoundException {
		File fich = new File ("C:\\jose\\alumno.dat");
		Alumno alu1=null;
		if (fich.exists()) {
			// Abrirfichero para lectura
			FileInputStream file;
			ObjectInputStream buffer;
			try {
				file = new FileInputStream
					("C:\\jose\\alumno.dat");
				buffer = new ObjectInputStream(file);
			} catch (IOException e) {
				System.out.println("No se ha podido abrir el fichero");
				System.out.println(e.getMessage());
				return null;
			}	
			
			// Lee el objeto guardado en el archivo alumno.dat
			try {
				alu1 = (Alumno) buffer.readObject();
			} catch (IOException e) {
				System.out.println("Error al escribir en el fichero");
				System.out.println(e.getMessage());
			}
			
			// Cerrar el fichero
			try {
				buffer.close();
				file.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				System.out.println(e.getMessage());
			}
			
		}
		return alu1;
	}
	public static void grabarAlumno(Alumno alu) {
		FileOutputStream file; // Iniciadores 

		ObjectOutputStream buffer; // Filtros

		

		// Abrir el fichero para escritura.

		try {

			file = new FileOutputStream

				("C:\\jose\\alumno.dat");

			buffer = new ObjectOutputStream(file);

		} catch (IOException e) {

			System.out.println("Se ha producido un error al abrir el fichero");

			System.out.println(e.getMessage());

			return;
		}

		// Grabar el objeto alumno.

		try {

			buffer.writeObject(alu);

		} catch (IOException e1) {

			System.out.println("Se ha producido un error al grabar la información del alumno");

			System.out.println(e1.getMessage());

		}

		// Cerrar el fichero.

		try {

			buffer.close();

			file.close();

		} catch (IOException e) {

			System.out.println("Se ha producido un error al cerrar el fichero");

			System.out.println(e.getMessage());

		}

		System.out.println("Se han guardado los datos del alumno");

	
	}
		
}		
	


