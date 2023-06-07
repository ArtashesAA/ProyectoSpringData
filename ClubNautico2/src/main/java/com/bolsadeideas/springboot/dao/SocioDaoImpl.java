package com.bolsadeideas.springboot.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.interfacesDao.ISocioDao;
import com.bolsadeideas.springboot.modelo.Socio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class SocioDaoImpl implements ISocioDao {

	public EntityManagerFactory fabrica;

	public Boolean crearSocio(Socio s) {
		EntityManager em = this.fabrica.createEntityManager();

		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();
		em.persist(s);
		try {
			transaccion.commit();
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public Boolean actualizarSocio(String dni, Socio s) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();

		try {
			Socio socioExistente = em.find(Socio.class, dni);
			if (socioExistente != null) {
				socioExistente.setNombre(s.getNombre());
				socioExistente.setApellidos(s.getApellidos());
				socioExistente.setTelefono(s.getTelefono());
				socioExistente.setDireccion(s.getDireccion());
				socioExistente.setBarcos(s.getBarcos());

				em.persist(socioExistente);
				transaccion.commit();
			} else {
				return false;
			}
		} finally {
			em.close();
		}

		return true;
	}

	public Boolean eliminarSocio(String dni) {
		EntityManager em = this.fabrica.createEntityManager();
		EntityTransaction transaccion = em.getTransaction();

		transaccion.begin();

		try {
			Socio socioExistente = em.find(Socio.class, dni);
			if (socioExistente != null) {
				em.remove(socioExistente);
				transaccion.commit();
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		} finally {
			em.close();
		}

		return true;
	}

	public Socio obtenerSocioPorDni(String dni) {
		EntityManager em = this.fabrica.createEntityManager();

		String consulta = "SELECT s FROM Socio s where s.dni=:dni";

		Socio socio = em.createQuery(consulta, Socio.class).setParameter("dni", dni).getSingleResult();

		em.close();

		return socio;
	}

	public List<Socio> obtenerSocios() {
		EntityManager em = this.fabrica.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Socio> configConsulta = cb.createQuery(Socio.class);
		Root<Socio> raizSocio = configConsulta.from(Socio.class);

		configConsulta.select(raizSocio);

		List<Socio> socios = em.createQuery(configConsulta).getResultList();

		em.close();

		return socios;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Socio> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Socio> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Socio> entities) {
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
	public Socio getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Socio getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Socio getReferenceById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Socio> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Socio> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Socio> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Socio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Socio> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Socio> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Socio> findById(String id) {
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
	public void delete(Socio entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Socio> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Socio> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Socio> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Socio> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Socio> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Socio> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Socio> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Socio, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
