import java.io.Serializable;
import java.util.ArrayList;
 
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 4854486451470258537L;
	
	private int numeroCuenta;
	Cliente cliente;
	private ArrayList<Movimiento> movimientos;
	
	public Cuenta(int numeroCuenta, String nombre, int edad) {
		this.numeroCuenta = numeroCuenta;
		this.movimientos = new ArrayList<Movimiento>();
		this.cliente = new Cliente(nombre, edad);
	} 
	

	public void mover(String movimiento, float cantidad) {
		this.movimientos.add(new Movimiento(movimiento, cantidad));
	}
	
	public int getNumeroCuenta() {
		return numeroCuenta;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Movimiento>getMovimientos() {
		return movimientos;
	}
	
	public void borrar(int br){
		movimientos.remove(br);
	}
	
}
