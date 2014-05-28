package com.example.testing.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.testing.model.Libro;

public class LibroDummyDao implements ILibroDao {
	private List<Libro> libros = new ArrayList<Libro>();
	
	private int calcularId() {
		int id = 0;
		for (Libro l : libros) {
			if (l.getId() > id)
				id = l.getId();
		}
		
		return id + 1;
	}
	
	public void agregar(Libro libro) {
		if (libro.getId() == null)
			libro.setId(calcularId());
		libros.add(libro);
	}

	public void modificar(Libro libro) {
		Libro l = obtener(libro.getId());
		if (l != null) {
			l.setTitulo(libro.getTitulo());
			l.setAutor(libro.getAutor());
			l.setIsbn(libro.getIsbn());
		}
	}

	public Libro obtener(Integer id) {
		for (Libro l : libros) {
			if (l.getId().equals(id)) 
				return l;
		}
		return null;
	}

	public List<Libro> obtenerTodos() {
		return libros;
	}

	public void eliminar(Integer id) {
		Libro l = obtener(id);
		if (l != null) {
			libros.remove(l);
		}
	}

	public void eliminarTodos() {
		libros = new ArrayList<Libro>();
	}
	
}
