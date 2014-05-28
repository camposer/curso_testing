package com.example.testing.service;

import com.example.testing.util.Natural;

public interface ICalculadoraService {
	public Natural sumar(Natural a, Natural b);
	public Natural multiplicar(Natural a, Natural b);
	public Natural restar(Natural a, Natural b);
	public Natural dividir(Natural a, Natural b);
}
