package com.prueba2.tienda;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.tienda.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	listado();

    	
    }
    public static void listado() {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("EjemploJP");
		EntityManager em = factoria.createEntityManager();
		TypedQuery<Producto> query = em.createNamedQuery("Producto.findAll", Producto.class);
		List<Producto> productos = query.getResultList();
		
		for (Producto p :productos) {
			System.out.println(p.getCodigo() + " - " + p.getDescripcion() +
			" - " + p.getPrecio() + " € - " +  p.getStock() + " unidades.");
		}
		/*TypedQuery<Integer> query1 = em.createQuery("SELECT MAX(f.numero) FROM Factura f", Integer.class);
		Integer maxNumFactura = query1.getSingleResult();
		System.out.println("Último número de factura: " + maxNumFactura);*/
		TypedQuery<Cliente> query1 = em.createQuery("SELECT cli FROM Cliente cli", Cliente.class);
		List<Cliente>clientes = query1.getResultList();
		for (Cliente c :clientes) {
			System.out.println(c.getNombre() + " - " + c.getTlf()+ " - "+c.getCiudad()+" - "+c.getNif());
		}
}
}
