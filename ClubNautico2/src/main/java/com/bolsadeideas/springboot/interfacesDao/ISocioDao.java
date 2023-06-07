package com.bolsadeideas.springboot.interfacesDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsadeideas.springboot.modelo.Socio;

public interface ISocioDao extends JpaRepository<Socio, String> {

	Boolean crearSocio(Socio s);

	Boolean actualizarSocio(String dni, Socio s);

	Boolean eliminarSocio(String dni);

	Socio obtenerSocioPorDni(String dni);

	List<Socio> obtenerSocios();

}
