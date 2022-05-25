import java.io.Serializable;
 
public class Movimiento implements Serializable {
	private static final long serialVersionUID = 3057545624874202352L;
 
	private String movimiento;
	private float cantidad; 
	
	public Movimiento(String movimiento, float cantidad) {
		this.movimiento = movimiento;
		this.cantidad = cantidad;
	}
	
	
 
	public String getMovimiento() {
		return movimiento;
	}



	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}



	public float getCantidad() {
		return cantidad;
	}



	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	


	@Override
	public String toString() {
		return "Movimiento [Tipo de movimiento="+movimiento+",Cantidad="+cantidad+"]";
	}
}
