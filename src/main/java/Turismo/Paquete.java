package Turismo;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Paquete {

	@Id
	private String nombre;
	private int precio;
	
	// Una entidad uno a muchos. El CascadeType indica que las relaciones se persisten automaticamente.
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Salida> salidas = new ArrayList<Salida>();
	
	// Esta es una relacion ManyToMany. Por defecto, se crea una tala intermedia.
	// Al no especificar, los nombres de las tablas y atributos se definen por defecto.
	@ManyToMany(cascade=CascadeType.PERSIST)
	private List<Agencia> agenciasVenta = new ArrayList<Agencia>();
	
	
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
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public List<Agencia> getAgenciasVenta() {
		return agenciasVenta;
	}

	public void setAgenciasVenta(List<Agencia> agenciasVenta) {
		this.agenciasVenta = agenciasVenta;
	}
	
	public void addAgenciaVenta(Agencia agencia) {
		this.getAgenciasVenta().add(agencia);
	}

}
