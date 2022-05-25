package com.SpringFiesta1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	@Bean
	public Local local() {
		return new Local(180, "Calle Ocaña, 23");
	}

	@Bean
	public Fiesta fiesta() {
		Fiesta f = new Fiesta();
		f.setTipoMusica("Hip Hop");
		f.setNombre("Whiz Kalifa");

		// Inyección de dependencias.
		f.setLocal(local());

		return f;
	}
}
