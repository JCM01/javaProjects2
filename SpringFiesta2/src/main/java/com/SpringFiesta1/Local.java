package com.SpringFiesta1;

import org.springframework.stereotype.Service;

@Service
public class Local {
	private int aforo;
	private String direccion;

	public Local() {
		this.aforo = 200;
		this.direccion = "Calle Carabanchel, 34";

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
