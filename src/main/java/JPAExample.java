import jakarta.persistence.*;
import Turismo.*;
import java.util.Date;


public class JPAExample {

	
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager em = emf.createEntityManager();
		Salida salida = new Salida();
		Salida salida1 = new Salida();
		Salida salida2 = new Salida();
		Vuelo vuelo1 = new Vuelo();
		Vuelo vuelo2 = new Vuelo();
		Paquete paquete = new Paquete();
		
		
		salida.setNombre("Salida");
		salida.setCantSalidas(3);
		salida.setFechaSalida(new Date());
		
		paquete.setNombre("Paquete1");
		vuelo1.setNumeroVuelo("IB-101");
		vuelo1.setAerolinea("Iberia");
		vuelo1.setHoraSalida(new Date());
		vuelo2.setNumeroVuelo("PU-102");
		vuelo2.setAerolinea("Pluna");
		vuelo2.setHoraSalida(new Date());
		salida1.setNombre("Salida1");
		salida1.setCantSalidas(4);
		salida1.setVuelo(vuelo1);
		salida1.setFechaSalida(new Date());
		salida2.setNombre("Salida2");
		salida2.setCantSalidas(5);
		salida2.setVuelo(vuelo2);
		salida2.setFechaSalida(new Date());
		paquete.addSalida(salida1);
		paquete.addSalida(salida2);
		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(salida);
		em.persist(paquete);
		tx.commit();
		
		
		
		em.close();
		emf.close();
		
	}

}
