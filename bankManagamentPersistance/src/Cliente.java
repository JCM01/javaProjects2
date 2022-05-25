import java.io.Serializable;

 
public class Cliente implements Serializable {
	private static final long serialVersionUID = 4854486451470258537L;
	private String nombre;
	private int edad;
	
	public Cliente(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	
}
