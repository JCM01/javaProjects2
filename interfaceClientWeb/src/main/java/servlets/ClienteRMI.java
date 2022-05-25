package servlets;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI {
	private Registry registry;
	private MusicaInterfaceRMI canciones;
	
	public ClienteRMI() {
		super();
		try {
			this.registry = LocateRegistry.getRegistry("192.168.34.120", 5055);
			this.canciones = (MusicaInterfaceRMI) registry.lookup("miMusica");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String filtrar(String campo, String valor) {
		try {
			return canciones.buscarBanda("Queen");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
