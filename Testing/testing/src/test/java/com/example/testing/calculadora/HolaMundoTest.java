package com.example.testing.calculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class HolaMundoTest {
	@BeforeClass
	public static void incializar() {
		System.out.println("Inicializando");
	}
	
	@AfterClass
	public static void finalizar() {
		System.out.println("Finalizando");
	}
	
	@Before
	public void antes() {
		System.out.println("Antes de...");
	}
	
	@After
	public void despues() {
		System.out.println("Después de...");
	}
	
	@Test
	public void prueba1() {
		System.out.println("Esta es la prueba 1");
	}
	
	@Test
	public void prueba2() {
		System.out.println("Esta es la prueba 2");
	}
	
}
