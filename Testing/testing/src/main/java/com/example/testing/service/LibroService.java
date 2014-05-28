package com.example.testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.testing.dao.ILibroDao;
import com.example.testing.model.Libro;

@Service
@Transactional
public class LibroService implements ILibroService {
	@Autowired
	ILibroDao libroDao;

	public void agregarLibro(Libro libro) {
		libroDao.agregar(libro);
		//... 
	}

	public void modificarLibro(Libro libro) {
		libroDao.modificar(libro);
	}

	public Libro obtenerLibro(Integer id) {
		return libroDao.obtener(id);
	}

	public List<Libro> obtenerLibros() {
		return libroDao.obtenerTodos();
	}

	public void eliminarLibro(Integer id) {
		libroDao.eliminar(id);
	}

	public void eliminarLibros() {
		libroDao.eliminarTodos();
	}

}
