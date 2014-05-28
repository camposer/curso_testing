package com.example.testing.dao;

import java.util.List;

import com.example.testing.model.Libro;

public interface ILibroDao {
	public void agregar(Libro libro);
	public void modificar(Libro libro);
	public Libro obtener(Integer id);
	public List<Libro> obtenerTodos();
	public void eliminar(Integer id);
	public void eliminarTodos();
}
