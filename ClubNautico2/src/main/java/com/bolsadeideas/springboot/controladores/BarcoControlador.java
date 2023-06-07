package com.bolsadeideas.springboot.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.interfacesDao.IBarcoDao;
import com.bolsadeideas.springboot.modelo.Barco;


@RestController
@RequestMapping("/barcos")
public class BarcoControlador {

	@Autowired
	private final IBarcoDao barcoDao;

	public BarcoControlador(IBarcoDao barcoDao) {
		this.barcoDao = barcoDao;
	}

	@GetMapping
	public String obtenerTodosLosBarcos(Model model) {
	    model.addAttribute("titulo", "Listado de barcos");
	    model.addAttribute("barcos", barcoDao.findAll());
	    return "barcoForm";
	}


	@GetMapping("/{matricula}")
    public ResponseEntity<Barco> obtenerBarcoPorMatricula(@PathVariable String matricula) {
        Barco barco= barcoDao.obtenerBarcoPorMatricula(matricula);
        if (barco != null) {
            return ResponseEntity.ok(barco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@PostMapping("/createBarco")
	public ResponseEntity<Barco> crearBarco(@RequestBody Barco barco) {
		Boolean created = barcoDao.crearBarco1(barco);
		if (created) {
			return ResponseEntity.status(HttpStatus.CREATED).body(barco);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/{matricula}")
	public ResponseEntity<Barco> actualizarBarco(@PathVariable String matricula, @RequestBody Barco barco) {
		Barco barcoExistente = barcoDao.obtenerBarcoPorMatricula(matricula);
	        if (barcoExistente != null) {
	        	barco.setMatricula(matricula);
	        	barcoDao.actualizarBarco1(matricula, barco);
	            return ResponseEntity.ok(barco);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	}

	@DeleteMapping("/{matricula}")
	public ResponseEntity<Void> borrarBarco(@PathVariable String matricula) {
		Barco barcoExistente = barcoDao.obtenerBarcoPorMatricula(matricula);
        if (barcoExistente != null) {
        	barcoDao.eliminarBarco(matricula);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
	}
}
