package com.bolsadeideas.springboot.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "socio")
public class Socio {
	@Id
	@Column(name = "dni", nullable = false, columnDefinition = "VARCHAR(10)")
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String dni;

	@Column(name = "nombre", nullable = false, columnDefinition = "VARCHAR(50)")
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String nombre;

	@Column(name = "apellidos", nullable = false, columnDefinition = "VARCHAR(50)")
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String apellidos;

	@Column(name = "direccion", columnDefinition = "VARCHAR(100)")
	private String direccion;

	@Column(name = "telefono", columnDefinition = "VARCHAR(12)")
	private String telefono;

	@OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
	private List<Barco> barcos;

	public Socio() {
		this.barcos = new ArrayList<>();
	}

	public Socio(String dni, String nombre, String apellidos, String direccion, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.barcos = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public List<Barco> getBarcos() {
		return barcos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setBarcos(List<Barco> barcos) {
		this.barcos = barcos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Socio [getNombre()=" + getNombre() + ", getApelldnios()=" + getApellidos() + ", getDireccion()="
				+ getDireccion() + ", getTelefono()=" + getTelefono() + ", getId()=" + getDni() + "]";
	}

}
