package fila;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilaTest {
	
	Fila fila;

	@Before
	public void setUp() throws Exception {
		fila = new Fila();
	}

	@Test
	public void testInserindoNaFilaComSucesso() {
		fila.insereNaFila(1);
		
		
	}
	


}
