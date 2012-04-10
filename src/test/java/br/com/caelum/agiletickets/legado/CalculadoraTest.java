package br.com.caelum.agiletickets.legado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	private static final double PRECISAO = 0.001;
	
	private Calculadora calculadora;

	@Before
	public void init() {
		calculadora = new Calculadora();
	}
	
	@Test
	public void deveRetornar15QuandoMultiplicamos5e3() throws Exception {
		double resultado = calculadora.multiplica(5, 3);
		
		assertEquals(15.0, resultado, PRECISAO);
	}
	
	@Test
	public void deveRetornarMenos10QuandoMultiplicamos2eMenos5() throws Exception {
		double resultado = calculadora.multiplica(2, -5);
		
		assertEquals(-10.0, resultado, PRECISAO);
	}
	
	@Test
	public void deveRetornar7QuandoMultiplicamos7e1() throws Exception {
		double resultado = calculadora.multiplica(7, 1);
		
		assertEquals(7.0, resultado, PRECISAO);
	}
	
	@Test
	public void deveRetornar0QuandoMultiplicamosMenos17e0() throws Exception {
		double resultado = calculadora.multiplica(17, 0);
		
		assertEquals(0.0, resultado, PRECISAO);
	}
}
