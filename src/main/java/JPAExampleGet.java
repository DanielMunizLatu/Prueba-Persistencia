
import jakarta.persistence.*;
import Turismo.*;
import java.util.Date;
import org.eclipse.persistence.indirection.*;
import java.util.List;


public class JPAExampleGet {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Prueba");
		EntityManager em = emf.createEntityManager();
		
		Salida salida = em.find(Turismo.Salida.class, "Salida1");
		
		System.out.println(salida.getNombre());
		System.out.println(salida.getCantSalidas());
		System.out.println(salida.getFechaSalida());
		System.out.println(salida.getVuelo().getNumeroVuelo());
		System.out.println(salida.getVuelo().getAerolinea());
		System.out.println(salida.getVuelo().getHoraSalida());
		System.out.println("---------------------------------");
		
		
		Paquete paquete = em.find(Turismo.Paquete.class, "Paquete1");
		
		System.out.println(paquete.getNombre());
		IndirectList<Salida> listaSalida = (IndirectList<Salida>)paquete.getSalidas();
		
		for (int i=0; i < listaSalida.size(); i++) {
			Salida salidaOut = (Salida)listaSalida.get(i);
			System.out.println("-->" + salidaOut.getNombre());
			System.out.println("---->" + salidaOut.getVuelo().getNumeroVuelo());
		}
		
		

	}

}
