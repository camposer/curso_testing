package com.example.testing.service;

import java.util.List;

import com.example.testing.model.Libro;

public interface ILibroService {
	public void agregarLibro(Libro libro);
	public void modificarLibro(Libro libro);
	public Libro obtenerLibro(Integer id);
	public List<Libro> obtenerLibros();
	public void eliminarLibro(Integer id);
	public void eliminarLibros();
}
