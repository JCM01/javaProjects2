import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import registrormi.MusicaInterfaceRMI;

public class Cliente {
	public static void main(String[] args) {
		Registry registry;
		Scanner lector = new Scanner(System.in);
		try {
			registry = LocateRegistry.getRegistry("XXXXXXXXXX", 5055);
			System.out.println("Hemos obtenido el registro");
			MusicaInterfaceRMI canciones = (MusicaInterfaceRMI) registry.lookup("miMusica");
			System.out.println("Hemos obtenido el objeto remoto");
			System.out.println(); // Retorno de carro.
			String buscado;
			String opcion;
			do {
				escribirMenu();
				opcion = lector.nextLine().toUpperCase();
				switch (opcion) {
				case "T":
					System.out.println("Escribe t�tulo canci�n: ");
					buscado = lector.nextLine();
					System.out.println(canciones.buscarTitulo(buscado));
					break;
				case "B":
					System.out.println("Escribe nombre banda: ");
					buscado = lector.nextLine();
					System.out.println(canciones.buscarBanda(buscado));
					break;
				case "A":
					System.out.println("Escribe nombre �lbum: ");
					buscado = lector.nextLine();
					System.out.println(canciones.buscarAlbum(buscado));
					break;
				case "P":
					System.out.println("Escribe a�o de producci�n: ");
					buscado = lector.nextLine();
					int a = Integer.parseInt(buscado);
					System.out.println(canciones.buscarProducido(a));
					break;
				case "F":
					System.out.println("Programa finalizado");
					break;
				default:
					System.out.println("Opci�n incorrecta");
				}
			} while (!opcion.equals("F"));
		} catch (RemoteException | NotBoundException e) {
			System.out.println(e.getMessage());
		}
		lector.close();
	}

	private static void escribirMenu() {
		System.out.println();
		System.out.println("B�squeda de canciones");
		System.out.println("--------------------------");
		System.out.println("T = T�tulo");
		System.out.println("B = Banda");
		System.out.println("A = �lbum");
		System.out.println("P = A�o producci�n");
		System.out.println("F = Terminar programa");
		System.out.println("--------------------------");
		System.out.println("�Qu� opci�n eliges?");
	}
}
