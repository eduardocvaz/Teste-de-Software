package fila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class FilaTest {
	
	Fila fila;

	@Before
	public void setUp() throws Exception {
		fila = new Fila();
	}

	@Test
	public void testFilaVaziaSemInserirMembro() {
		assertTrue(fila.estaVazia());
	}
	
	@Test
	public void testFilaVaziaInserindoMembro() {
		fila.insereNaFila(1);
		assertFalse(fila.estaVazia());
	}
	
	@Test
	public void testFilaVaziaInserindoERemovendoMembro() {
		fila.insereNaFila(1);
		fila.removeDaFila();
		assertTrue(fila.estaVazia());
	}
	
	@Test
	public void testinserindoMembroFilaCheia() {
		fila.insereNaFila(1);
		fila.insereNaFila(2);
		fila.insereNaFila(3);
		fila.insereNaFila(4);
		fila.insereNaFila(5);

		try {
			fila.insereNaFila(6);
			
			fail("Deveria falhar ao tentar inserir em uma fila cheia");
		} catch (FilaCheiaException e) {
			  var expectedException =
			      assertThrows(
			    		  FilaCheiaException.class,
			          () -> {
			            throw new FilaCheiaException("Fila cheia");
			          });
			  assertEquals(e.getMessage(), expectedException.getMessage());
		}
		
	}
	
	@Test
	public void testremoverMembroFilaVazia() {
		try {
			fila.removeDaFila();
			
			fail("Deveria falhar ao tentar remover em uma fila vazia");
		} catch (FilaVaziaException e) {
			  var expectedException =
			      assertThrows(
			    		  FilaVaziaException.class,
			          () -> {
			            throw new FilaVaziaException("Fila vazia");
			          });
			  assertEquals(e.getMessage(), expectedException.getMessage());
		}
		
	}
	
	@Test
	public void testVerificandoPrimeiroElemento() {
		fila.insereNaFila(1);
		fila.insereNaFila(2);
		fila.insereNaFila(3);
		fila.insereNaFila(4);
		
		assertEquals(1, fila.removeDaFila());
	}
	
	@Test
	public void testVerificandoUltimoElemento() {
		fila.insereNaFila(1);
		fila.insereNaFila(2);
		fila.insereNaFila(3);
		fila.insereNaFila(4);
		
		fila.removeDaFila();
		fila.removeDaFila();
		fila.removeDaFila();

		
		assertEquals(4, fila.removeDaFila());
	}
	
	
	


}
