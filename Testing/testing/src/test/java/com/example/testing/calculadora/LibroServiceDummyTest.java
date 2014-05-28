package com.example.testing.calculadora;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.testing.model.Libro;
import com.example.testing.service.ILibroService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-dummy.xml"})
public class LibroServiceDummyTest {
	@Autowired
	private ILibroService libroService;

	@Before
	public void before() {
		libroService.agregarLibro(new Libro(1, "titulo1", "autor1", "isbn1"));
		libroService.agregarLibro(new Libro(2, "titulo2", "autor2", "isbn2"));
		libroService.agregarLibro(new Libro(3, "titulo3", "autor3", "isbn3"));		
	}
	
	@After
	public void after() {
		libroService.eliminarLibros();
	}
	
	@Test
	public void validarAgregarLibro() {
		Libro l = new Libro();
		l.setTitulo("titulo");
		l.setAutor("autor");
		l.setIsbn("isbn");
		
		libroService.agregarLibro(l);
		Integer id = l.getId();
		
		Assert.assertNotNull(libroService.obtenerLibro(id));
		Assert.assertEquals("titulo", libroService.obtenerLibro(id).getTitulo());
	}
	
	
	@Test
	public void validarModificarLibro() {
		Libro l = libroService.obtenerLibro(1);
		l.setTitulo("modificado");
		libroService.modificarLibro(l);
		
		l = libroService.obtenerLibro(1);
		
		Assert.assertEquals("modificado", libroService.obtenerLibro(1).getTitulo());
	}
	
	@Test
	public void validarObtenerLibro() {
		Integer id = 1;
		
		Assert.assertNotNull(libroService.obtenerLibro(id));
		Assert.assertEquals("titulo1", libroService.obtenerLibro(id).getTitulo());
	}
	
	@Test
	public void validarObtenerLibros() {
		Assert.assertNotNull(libroService.obtenerLibros());
		Assert.assertEquals(3, libroService.obtenerLibros().size());		
	}
	
	@Test
	public void validarEliminarLibro() {
		Integer id = 1;
		libroService.eliminarLibro(id);
		Assert.assertNull(libroService.obtenerLibro(id));
	}
	
}
