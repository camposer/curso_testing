package com.example.testing.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@Table(name="libro")
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String autor;

	private String isbn;

	private String titulo;

	public Libro() {
	}
	
	public Libro(String titulo, String autor, String isbn) {
		this(null, titulo, autor, isbn);
	}

	public Libro(Integer id, String titulo, String autor, String isbn) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", autor=" + autor + ", isbn=" + isbn
				+ ", titulo=" + titulo + "]";
	}

}