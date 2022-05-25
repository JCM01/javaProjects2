package com.SpringFiesta1;

public class Fiesta {

	private String tipoMusica;
	private String nombre;
	private Local local;

	public Fiesta(String tipoMusica, String nombre, Local local) {
		super();
		this.tipoMusica = tipoMusica;
		this.nombre = nombre;
		this.local = local;
	}
	
	public Fiesta() {
		
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
