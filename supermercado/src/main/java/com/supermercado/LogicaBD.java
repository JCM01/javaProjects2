package com.supermercado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.supermercado.model.Producto;

public class LogicaBD {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("supermercado");
	private static EntityManager em = factory.createEntityManager();
	
	public LogicaBD() {
		
	}

	public static List<Producto> listaProductos() {
		TypedQuery<Producto> query = em.createNamedQuery("Producto.findAll", Producto.class);
		List<Producto> productos = query.getResultList();
		return productos;
	}
}

