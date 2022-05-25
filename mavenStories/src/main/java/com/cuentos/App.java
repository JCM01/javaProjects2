package com.cuentos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cuentos.interciclica.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Hito02");
    	EntityManager em = factoria.createEntityManager();

    	TypedQuery<Usuario> query1 = em.createQuery("SELECT user FROM Usuario user ", Usuario.class);
    	List<Usuario>usuarios = query1.getResultList();

    	for (Usuario u : usuarios) {
    		
    		
    		System.out.println("Para el usuario : "+u.getNombre()+" "+u.getApellidos());
    		
    		for (int i = 0; i < u.getCuentos().size(); i++) {
    			System.out.println(u.getCuentos().get(i));
    		}
    		
    	

    		
    }
}
}
