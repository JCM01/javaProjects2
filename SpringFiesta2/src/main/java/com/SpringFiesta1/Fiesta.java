package com.SpringFiesta1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Fiesta {

	private String tipoMusica;
	private String nombre;
	private Local local;

	public Fiesta() {
		this.tipoMusica = "Hardstyle";
		this.nombre = "Brenan Heart";

	}

	public String celebrar() {
		return "La fiesta que se celebra en " + local.getDireccion() + " con aforo de " + local.getAforo()
				+ " personas será de musica " + tipoMusica;

	}

	public String terminar() {
		return "La fiesta " + nombre + " ha llegado a su fin.";
	}

	public Local getLocal() {
		return local;
	}

	@Autowired
	public void setLocal(Local local) {
		this.local = local;
	}

	public String getTipoMusica() {
		return tipoMusica;
	}

	public void setTipoMusica(String tipoMusica) {
		this.tipoMusica = tipoMusica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

