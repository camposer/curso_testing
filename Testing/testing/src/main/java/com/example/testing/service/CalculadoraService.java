package com.example.testing.service;

import org.springframework.stereotype.Service;

import com.example.testing.util.Natural;

@Service
public class CalculadoraService {
	public Natural sumar(Natural a, Natural b) {
		return new Natural(a.getN() + b.getN());
	}
	
	public Natural multiplicar(Natural a, Natural b) {
		return new Natural(a.getN() * b.getN());
	}
	
	public Natural restar(Natural a, Natural b) { 
		if (b.getN() > a.getN())
			throw new SustraendoInvalidoException();
		
		return new Natural(a.getN() - b.getN());
	}
	
	public Natural dividir(Natural a, Natural b) {
		if (b.getN() == 0)
				throw new DivisorInvalidoException();

		return new Natural(a.getN() / b.getN());
	}
}
