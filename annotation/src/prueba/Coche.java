package prueba;
import anotaciones.*;

public class Coche {
	String marca;
	String modelo;
	int velocidad;
	
	public Coche(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.velocidad = 0;
	}

	@Editor(autor = "MIGUEL PICAFLOR", edicion = 3, anio = 2011)
	public void acelerar() {
		// Este es el método que contiene la anotación.
		this.velocidad +=10;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", velocidad=" + velocidad + "]";
	}
}
