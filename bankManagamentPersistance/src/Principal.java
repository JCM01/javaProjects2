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
		
		Cuenta cue = recuperarCuenta();
		
		String opc = "";
		lector = new Scanner(System.in);
		
		if (cue==null) {
			
			//Construir un nuevo objeto cuenta
			System.out.println("Nombre cliente: ");
			String nombre = lector.nextLine();
			System.out.println("Edad: ");
			int edad = lector.nextInt();
			System.out.println("Numero de cuenta: ");
			int numeroCuenta = lector.nextInt();
			
			lector.nextLine(); // Limpiar el buffer.
			cue = new Cuenta(numeroCuenta, nombre, edad);
		}
		
		

		do {
			System.out.println("1. Añadir movimiento.");
			System.out.println("2. Modificar movimiento.");
			System.out.println("3. Borrar movimiento (historial).");
			System.out.println("4. Ver todos los movimientos.");
			System.out.println("5. Ver retiradas.");
			System.out.println("6. Ver ingresos.");
			System.out.println("7. Terminar programa.");
			System.out.println("--------------------------------");
			System.out.println("Elegir opción");
			opc = lector.nextLine();
			switch (opc) {
			case "1":
				opcion1(cue);
				break;
			case "2":
				opcion2(cue);
				break;
			case "3":
				opcion3(cue);
				break;
			case "4":
				opcion4(cue);
				break;
			case "5":
				opcion5(cue);
				break;
			case "6":
				opcion6(cue);
				break;
			case "7":
				System.out.println("Fin del programa");
				//Grabar fichero
				opcion7(cue);
				grabarCuenta(cue);
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		} while (!opc.equals("7"));

		lector.close();

		
	}

	private static void opcion1(Cuenta a) {
		System.out.println("Ingreso o retirada: ");
		String mov = lector.nextLine();
		System.out.println("Cantidad: ");
		float c = lector.nextInt();
		lector.nextLine(); // Limpiar el buffer.
		a.mover(mov, c);
	}

	private static void opcion2(Cuenta a) {
		int indic = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			System.out.println(indic+ " --- " +a.getMovimientos().get(i).toString());
			indic++;
		}
		
		Scanner br = new Scanner(System.in);
		System.out.println("Índice a modificar: ");
		
		int num = br.nextInt();
		
		a.borrar(num);
		
		System.out.println("Ingreso o retirada: ");
		String mov = lector.nextLine();
		System.out.println("Cantidad: ");
		int c = lector.nextInt();
		lector.nextLine();
		a.mover(mov, c);
	}
	
	private static void opcion3(Cuenta a) {
		int indic = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			System.out.println(indic+ " --- " +a.getMovimientos().get(i).toString());
			indic++;
		}
		Scanner br = new Scanner(System.in);
		System.out.println("Índice a borrar: ");
		
		int num = br.nextInt();
		
		a.borrar(num);
	}

	private static void opcion4(Cuenta a) {
		//System.out.println("Nombre: "+a.getNombre().toString()+" --- Edad: "+a.getEdad());
		System.out.println("Nombre: "+a.getCliente().getNombre()+" --- Edad: "+a.getCliente().getEdad());
		int indic = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			System.out.println(indic+ " --- " +a.getMovimientos().get(i).toString());
			indic++;
		}

	}

	private static void opcion5(Cuenta a) {
		int indic = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			Movimiento c = a.getMovimientos().get(i);
			if (c.getMovimiento().toLowerCase().equals("retirada")) {
				System.out.println(indic+ " --- " +c.toString());
				indic++;
			}
		}
	}

	private static void opcion6(Cuenta a) {
		int indic = 0;
		for (int i = 0; i < a.getMovimientos().size(); i++) {
			Movimiento c = a.getMovimientos().get(i);
			if (c.getMovimiento().toLowerCase().equals("ingreso")) {
				System.out.println(indic+ " --- " +c.toString());
				indic++;
			}
		}
	}
	
	
	private static void opcion7(Cuenta a) { 
		float total=0;
		
		for (int i = 0; i <a.getMovimientos().size(); i++) { 
			Movimiento c = a.getMovimientos().get(i);
			
			if (c.getMovimiento().toLowerCase().equals("ingreso")) {
				total+=c.getCantidad(); 
				
			} else if (c.getMovimiento().toLowerCase().equals("retirada")){
				total-=c.getCantidad(); 
				
			} else {
				System.out.println("Movimiento no válido");
	  
	  		}  
		}//cierra for
		System.out.println(total);
	}//cierra opcion7 
	
	
	private static Cuenta recuperarCuenta() throws ClassNotFoundException {
		File fich = new File ("C:\\manuel\\cuenta.dat");
		Cuenta cue1=null;
		if (fich.exists()) {
			// Abrirfichero para lectura
			FileInputStream file;
			ObjectInputStream buffer;
			try {
				file = new FileInputStream
					("C:\\manuel\\cuenta.dat");
				buffer = new ObjectInputStream(file);
			} catch (IOException e) {
				System.out.println("No se ha podido abrir el fichero");
				System.out.println(e.getMessage());
				return null;
			}	
			
			// Lee el objeto guardado en el archivo cuenta.dat
			try {
				cue1 = (Cuenta) buffer.readObject();
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
		return cue1;
	}//cierra RecuperarAlumno
	
	public static Cuenta grabarCuenta(Cuenta cue){
		FileOutputStream file; //Iniciadores
		ObjectOutputStream buffer; //Filtros
		
		//Abrir el fichero para escritura
		try {
			file = new FileOutputStream("C:\\manuel\\cuenta.dat");
			buffer = new ObjectOutputStream(file);
		} catch (IOException e) {
			System.out.println("Se ha producido un error al abrir el fichero");
			System.out.println(e.getMessage());
			return null;
		}	
		
		//Grabar el objeto alumno.
		try {
			buffer.writeObject(cue);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Se ha producido un error al grabar la información del fichero");
			System.out.println(e1.getMessage());
		}
		
		//Cerrar el fichero
		try {
			buffer.close();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Se ha producido un error al cerrar el fichero");
			System.out.println(e.getMessage());
		}
		System.out.println("Se ha guardado el fichero");
		return cue;
	}
		
}