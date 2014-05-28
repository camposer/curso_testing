package com.example.testing.util;

import com.example.testing.exception.NaturalInvalidoException;

public class Natural {
	private int n;
	
	public Natural(int n) {
		if (n < 0)
			throw new NaturalInvalidoException();
		
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
