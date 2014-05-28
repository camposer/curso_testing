package com.example.testing.calculadora;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.testing.dao.ILibroDao;
import com.example.testing.model.Libro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
@Transactional // Garantiza que al finalizar el test hace rollback
public class LibroDaoTest {
	@Autowired
	private ILibroDao libroDao;

	@Test
	public void validarAgregarLibro() {
		Libro l = new Libro("titulo", "autor", "isbn");
		libroDao.agregar(l); // Devuelve el último id asignado por la BD
		
		Assert.assertNotNull(libroDao.obtener(l.getId()));
	}
}
