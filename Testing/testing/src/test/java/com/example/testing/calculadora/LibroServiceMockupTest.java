package com.example.testing.calculadora;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.testing.model.Libro;
import com.example.testing.service.ILibroService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-dummy.xml"})
public class LibroServiceMockupTest {
	private ILibroService libroService; // No inyectado por Spring

	@Before
	public void before() {
		Libro l = new Libro("mititulo", "miautor", "miisbn");
		libroService = Mockito.mock(ILibroService.class);
		Mockito.when(libroService.obtenerLibro(1)).thenReturn(l);
	}
	
	@Test
	public void mockito() {
		Assert.assertNull(libroService.obtenerLibro(2));
		Assert.assertEquals("mititulo", 
				libroService.obtenerLibro(1).getTitulo());	
	}
}
