package com.bolsadeideas.springboot.interfacesDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolsadeideas.springboot.modelo.Barco;
import com.bolsadeideas.springboot.modelo.Salida;

public interface ISalidaDao extends JpaRepository<Salida, String> {

	Boolean crearBarco1(Barco b);

	Boolean actualizarBarco1(String matricula, Barco b);

	Boolean eliminarBarco(String matricula);

	List<Barco> getBarcos();

	Barco getPorMatricula(String matricula);

}
