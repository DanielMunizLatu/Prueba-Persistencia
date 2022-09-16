package Turismo;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Entity implementation class for Entity: Salida
 *
 */

@Entity
public class Salida {

	@Id
	private String nombre;
	@Column(name="cant_Salida")
	private int cantSalidas;
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
