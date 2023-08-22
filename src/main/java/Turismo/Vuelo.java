package Turismo;

import java.util.Date;
import jakarta.persistence.*;

@Entity

// Definimos un nombre específico para el nombre de la tabla. Por defecto sería Vuelo.
@Table(name="Flight")
// Los países los definimos en una tabla secundaria. Ojo, porque al obtener la entidad
// hay dos joins.
@SecondaryTables({
	@SecondaryTable(name="pais")
})
public class Vuelo {
	
	@Id
	private String numeroVuelo;
	private String aerolinea;
	private Date horaSalida;
	
	// En este caso no queremos guardar el precio. Por eso la columna la hacemos transient.
	@Transient
	private int precio;
	
	// En el caso de paisOrigen y paisDestino, utilizamos la tabla secundaria.
	@Column(table="pais")
	private String paisOrigen;
	@Column(table="pais")
	private String paisDestino;
	
		
	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	
	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	
	public String getAerolinea() {
		return aerolinea;
	}
	
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	public Date getHoraSalida() {
		return horaSalida;
	}
	
	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getPaisOrigen() {
		return paisOrigen;
	}
	
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	
	public String getPaisDestino() {
		return paisDestino;
	}
	
	public void setPaisDestino(String paisDestino) {
		this.paisDestino = paisDestino;
	}	

}
