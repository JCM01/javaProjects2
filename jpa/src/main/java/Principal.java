
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Cliente;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Vamos a comprobar el funcionamiento de JPA");

		EntityManagerFactory factory = null;
		EntityManager em = null;

		try {
			factory = Persistence.createEntityManagerFactory("EjemploJPA");
			System.out.println("Hemos creado el Entity Manager Factory");
			em = factory.createEntityManager();
			System.out.println("Hemos creado en Entity Manager");
			Cliente yo;
			yo = new Cliente("51666372R", "PEDRITO PICAFLOR", "C/ CRISTOBAL, 54", "MADRID", "666886666");
			EntityTransaction tx = em.getTransaction();
			System.out.println("Hemos iniciado la transacción");
			tx.begin();
			em.persist(yo);
			tx.commit();
			System.out.println("Hemos persistido el objeto en la BD");

		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
