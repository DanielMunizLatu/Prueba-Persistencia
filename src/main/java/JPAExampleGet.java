
import jakarta.persistence.*;
import Turismo.*;

import java.util.List;

import org.eclipse.persistence.indirection.*;


public class JPAExampleGet {

	public static void main(String[] args) {
		
		// Creamos un Entity Manager basado en la persistence unit Pruea
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager em = emf.createEntityManager();
		
		// Realizados una busqueda por ID utilizando directamente el Entity Manager
		Salida salida = em.find(Turismo.Salida.class, "Salida1");
		
		// Navegamos la entidad aca se puede ver que los valores se sacan de la BD.
		System.out.println(salida.getNombre());
		System.out.println(salida.getCantSalidas());
		System.out.println(salida.getFechaSalida());
		System.out.println(salida.getVuelo().getNumeroVuelo());
		System.out.println(salida.getVuelo().getAerolinea());
		System.out.println(salida.getVuelo().getHoraSalida());
		System.out.println("---------------------------------");
		
		// Obtenemos una nueva entidad
		Paquete paquete = em.find(Turismo.Paquete.class, "Paquete 1");
		
		System.out.println(paquete.getNombre());
		IndirectList<Salida> listaSalida = (IndirectList<Salida>)paquete.getSalidas();
		//IndirectList es una coleccion de la API de java, para traer datos de una DB
		
		for (int i=0; i < listaSalida.size(); i++) {
			Salida salidaOut = (Salida)listaSalida.get(i);
			System.out.println("-->" + salidaOut.getNombre());
			System.out.println("---->" + salidaOut.getVuelo().getNumeroVuelo());
		}
		
		//Query con JPQL. Obtenemos la informacion solo de los vuelos que van a Jamaica.
		Query query = em.createQuery("SELECT v FROM Vuelo v WHERE v.paisDestino = 'Jamaica'");
		List<Vuelo> result = query.getResultList();
		for (Vuelo vuelo: result) {
			System.out.println("ID de Vuelo a Jamaica: " + vuelo.getNumeroVuelo());
		}
	}

}
