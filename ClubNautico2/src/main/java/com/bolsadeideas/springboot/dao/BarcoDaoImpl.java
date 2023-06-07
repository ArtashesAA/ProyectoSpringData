package com.bolsadeideas.springboot.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.interfacesDao.IBarcoDao;
import com.bolsadeideas.springboot.modelo.Barco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class BarcoDaoImpl implements IBarcoDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Boolean crearBarco1(Barco b) {
		try {
			entityManager.persist(b);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public Boolean actualizarBarco1(String matricula, Barco b) {
		try {
			Barco barcoExistente = entityManager.find(Barco.class, matricula);
			if (barcoExistente != null) {
				barcoExistente.setNombre(b.getNombre());
				barcoExistente.setCapacidad(b.getCapacidad());
				barcoExistente.setCuota(b.getCuota());
				barcoExistente.setNumAmarre(b.getNumAmarre());
				barcoExistente.setSalidas(b.getSalidas());
				barcoExistente.setSocio(b.getSocio());
				entityManager.merge(barcoExistente);
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean eliminarBarco(String matricula) {
		try {
			Barco barcoExistente = entityManager.find(Barco.class, matricula);
			if (barcoExistente != null) {
				entityManager.remove(barcoExistente);
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Barco> obtenerBarcos() {
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Barco> cq = cb.createQuery(Barco.class);
			Root<Barco> root = cq.from(Barco.class);
			cq.select(root);
			TypedQuery<Barco> query = entityManager.createQuery(cq);
			return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	public Barco obtenerBarcoPorMatricula(String matricula) {
		try {
			return entityManager.find(Barco.class, matricula);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Barco> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Barco> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Barco> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Barco getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Barco getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Barco getReferenceById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Barco> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Barco> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Barco> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Barco> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Barco> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Barco> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Barco> findById(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Barco entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Barco> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Barco> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Barco> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Barco> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Barco> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Barco> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Barco> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Barco, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
