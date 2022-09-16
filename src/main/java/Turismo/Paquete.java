package Turismo;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/**
 * Entity implementation class for Entity: Paquete
 *
 */

@Entity
public class Paquete {

	@Id
	private String nombre;
	//El mappedBy elimina la necesidad de una tabla intermedia.
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Salida> salidas = new ArrayList<Salida>();
	
	

	public Paquete() {
		super();
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Salida> getSalidas() {
		return salidas;
	}
	
	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}
   
	public void addSalida(Salida salida) {
		this.salidas.add(salida);
	}
	
}
