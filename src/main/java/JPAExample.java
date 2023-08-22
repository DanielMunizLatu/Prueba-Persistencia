import jakarta.persistence.*;
import Turismo.*;
import java.util.Date;

public class JPAExample {

	
	public static void main(String[] args) {

		// Creamos una Entidad basado en el Persitence Unit Prueba definido en el persistence.xml
		// Este es necesario, con el mismo nombre que el de persistence.xml Prueba
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager em = emf.createEntityManager();
		
		//Definimos varias instancias de las entidades. Por ahora no estan manejadas por el ORM.
		Salida salida1 = new Salida();
		Salida salida2 = new Salida();
		
		Vuelo vuelo1 = new Vuelo();
		Vuelo vuelo2 = new Vuelo();
		
		
		Agencia agencia1 = new Agencia();
		Agencia agencia2 = new Agencia();
		Paquete paquete = new Paquete();
		
		paquete.setNombre("Paquete 1");
		
		vuelo1.setNumeroVuelo("IB-0044");
		vuelo1.setAerolinea("Iberia");
		vuelo1.setHoraSalida(new Date());
		vuelo1.setPaisOrigen("Uruguay");
		vuelo1.setPaisDestino("Jamaica");
		vuelo2.setNumeroVuelo("PU-0045");
		vuelo2.setAerolinea("Pluna");
		vuelo2.setHoraSalida(new Date());
		vuelo2.setPaisOrigen("Uruguay");
		vuelo2.setPaisDestino("Brasil");
		
		salida1.setNombre("Salida1");
		salida1.setCantSalidas(4);
		salida1.setVuelo(vuelo1);
		salida1.setFechaSalida(new Date());
		
		salida2.setNombre("Salida2");
		salida2.setCantSalidas(8);
		salida2.setVuelo(vuelo2);
		salida2.setFechaSalida(new Date());
		
		agencia1.setNombre("VolaConmigo.com");
		agencia1.setPermiso(12);
		agencia1.setContacto("HarryStyles@volaconmigo.com");
		agencia2.setNombre("AprovechaLaVida.com");
		agencia2.setPermiso(15);
		agencia2.setContacto("contacto@aprovechalavida.com");
		
		paquete.addSalida(salida1);
		paquete.addSalida(salida2);
		paquete.addAgenciaVenta(agencia1);
		paquete.addAgenciaVenta(agencia2);
		
		
		// Aca creamos una transaccion asociada con el entity manager y las entidades pasan a estar managed.
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		System.out.println("Voy a persistir");
		em.persist(vuelo1);
		em.persist(vuelo2);
		em.persist(salida2);
		System.out.println("Persisti");
		em.persist(paquete);
		tx.commit();
		
		// Cerramos el Entity Manager. Es importante para que cierre las conexiones con la base de datos.
		em.close();
		emf.close();
		
	}

}
