package com.tienda.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tienda.model.Detalle;
import com.tienda.model.Factura;
import com.tienda.model.Producto;

public class FacturasConDetalles {

	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Ejemplo-JPA");
		EntityManager em = factoria.createEntityManager();
		TypedQuery<Factura> query = em.createNamedQuery("Factura.findAll", Factura.class);
		List<Factura> facturas = query.getResultList();
		for (Factura f : facturas) {
			System.out.println(f.getNumero() + " - " + f.getFecha() + " - " + f.getCliente().getNombre());
			for (Detalle d : f.getDetalles()) {
				Producto p = d.getProducto();
				System.out.println("    " + p.getCodigo() + " - " + p.getDescripcion() + " - " + d.getPrecio() + "� "
						+ d.getUnidades());
			}
		}
	}
}
