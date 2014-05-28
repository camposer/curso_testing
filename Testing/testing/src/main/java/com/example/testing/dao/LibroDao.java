package com.example.testing.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.testing.model.Libro;

public class LibroDao implements ILibroDao {
	@PersistenceContext
	@Autowired
	private EntityManager entityManager;
	
	public void agregar(Libro libro) {
		entityManager.persist(libro);
	}

	public void modificar(Libro libro) {
		entityManager.merge(libro);
	}

	public Libro obtener(Integer id) {
		return entityManager.find(Libro.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Libro> obtenerTodos() {
		return entityManager.createQuery("from Libro").getResultList();
	}

	public void eliminar(Integer id) {
		Query q = entityManager.createQuery("delete from Libro where id = :id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

	public void eliminarTodos() {
		Query q = entityManager.createQuery("delete from Libro");
		q.executeUpdate();
	}
	
}
