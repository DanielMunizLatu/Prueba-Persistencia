package Turismo;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="Flight")
public class Vuelo {
	
	@Id
	private String numeroVuelo;
	private String aerolinea;
	private Date horaSalida;
	
	
	
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
	

}
