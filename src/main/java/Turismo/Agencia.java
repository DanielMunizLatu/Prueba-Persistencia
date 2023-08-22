package Turismo;

import java.lang.String;

import jakarta.persistence.*;

@Entity
public class Agencia {

	@Id
	private String nombre;
	private int permiso;
	private String contacto;
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPermiso() {
		return permiso;
	}
	
	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}
	
	public String getContacto() {
		return contacto;
	}
	
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
}
