package com.SpringFiesta1;

public class Local {
	private int aforo;
	private String direccion;

	public Local(int aforo, String direccion) {
		super();
		this.aforo = aforo;
		this.direccion = direccion;
		
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
