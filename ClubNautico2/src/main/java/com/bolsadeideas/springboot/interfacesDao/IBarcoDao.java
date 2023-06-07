package com.bolsadeideas.springboot.interfacesDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsadeideas.springboot.modelo.Barco;

public interface IBarcoDao extends JpaRepository<Barco, String> {

	Boolean crearBarco1(Barco b);

	Boolean actualizarBarco1(String matricula, Barco b);

	Boolean eliminarBarco(String matricula);

	List<Barco> obtenerBarcos();

	Barco obtenerBarcoPorMatricula(String matricula);

}
