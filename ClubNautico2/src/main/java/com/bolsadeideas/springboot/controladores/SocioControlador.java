package com.bolsadeideas.springboot.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.interfacesDao.ISocioDao;
import com.bolsadeideas.springboot.modelo.Socio;

@RestController
@RequestMapping("/socios")
public class SocioControlador {

	private final ISocioDao socioDao;

	public SocioControlador(ISocioDao socioDao) {
		this.socioDao = socioDao;
	}

	@GetMapping
    public ResponseEntity<List<Socio>> obtenerTodosLosSocios() {
        List<Socio> socios = socioDao.obtenerSocios();
        return ResponseEntity.ok(socios);
    }

	@GetMapping("/{dni}")
    public ResponseEntity<Socio> obtenerSocioPorDni(@PathVariable String dni) {
        Socio socio = socioDao.obtenerSocioPorDni(dni);
        if (socio != null) {
            return ResponseEntity.ok(socio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@PostMapping
	public ResponseEntity<Socio> createSocio(@RequestBody Socio socio) {
		Boolean created = socioDao.crearSocio(socio);
		if (created) {
			return ResponseEntity.status(HttpStatus.CREATED).body(socio);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/{dni}")
	public ResponseEntity<Socio> actualizarSocio(@PathVariable String dni, @RequestBody Socio socio) {
		 Socio socioExistente = socioDao.obtenerSocioPorDni(dni);
	        if (socioExistente != null) {
	            socio.setDni(dni);
	            socioDao.actualizarSocio(dni, socio);
	            return ResponseEntity.ok(socio);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	}

	@DeleteMapping("/{dni}")
	public ResponseEntity<Void> eliminarSocio(@PathVariable String dni) {
		Socio socioExistente = socioDao.obtenerSocioPorDni(dni);
        if (socioExistente != null) {
            socioDao.eliminarSocio(dni);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
	}
}
