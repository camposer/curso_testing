package com.example.testing.calculadora;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.testing.exception.NaturalInvalidoException;
import com.example.testing.service.CalculadoraService;
import com.example.testing.service.DivisorInvalidoException;
import com.example.testing.service.SustraendoInvalidoException;
import com.example.testing.util.Natural;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CalculadoraServiceTest {
	@Autowired
	private CalculadoraService calculadoraService;

	@Test(expected=NaturalInvalidoException.class)
	public void validarNatural() {
		new Natural(-2);
	}
	
	@Test
	public void validarSumar() {
		Natural a = new Natural(2);
		Natural b = new Natural(3);
		
		Natural c = calculadoraService.sumar(a, b);
		
		Assert.assertEquals(5, c.getN());
	}

	@Test(expected=SustraendoInvalidoException.class)
	public void validarRestar() {
		Natural a = new Natural(4);
		Natural b = new Natural(3);
		
		Natural c = calculadoraService.restar(a, b);
		
		Assert.assertEquals(1, c.getN());

		// Validando excepcion
		b = new Natural(8);
		
		calculadoraService.restar(a, b);
	}

	@Test
	public void validarMultiplicar() {
		Natural a = new Natural(2);
		Natural b = new Natural(3);
		
		Natural c = calculadoraService.multiplicar(a, b);
		
		Assert.assertEquals(6, c.getN());
	}
	
	@Test(expected=DivisorInvalidoException.class)
	public void validarDividir() {
		Natural a = new Natural(4);
		Natural b = new Natural(2);
		
		Natural c = calculadoraService.dividir(a, b);
		
		Assert.assertEquals(2, c.getN());

		// Validando excepcion
		b = new Natural(0);
		
		calculadoraService.dividir(a, b);
	}
	
}
