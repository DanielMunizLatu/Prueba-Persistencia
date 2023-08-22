package Turismo;

import jakarta.persistence.*;
import java.util.Date;


@Entity
public class Salida {

	@Id
	private String nombre;
	
	// Aca¡ especificamos un nombre  para el nombre de la columna.
	// Por defecto es el nombre de la columna
	@Column(name="cant_Salida")
	private int cantSalidas;
	
	// Aca tenemos una relacion uno a uno. Por defecto no se crea tabla. 
	// Especificamos una columna que va a ser la que realiza el Join.
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Vuelo_Id")
	private Vuelo vuelo;
	private Date fechaSalida;
	
	
	public Salida() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantSalidas() {
		return cantSalidas;
	}

	public void setCantSalidas(int cantSalidas) {
		this.cantSalidas = cantSalidas;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

}
