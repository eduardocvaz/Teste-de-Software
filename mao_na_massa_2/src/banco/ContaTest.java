package banco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ContaTest {
	
	Conta conta1;
	Conta conta2;
	
	
	@Before
	public void setUp() throws Exception {
		conta1 = new Conta("01", 0);
		conta2 = new Conta("02", 0);
	}
	
	
	@Test
	public void testAssertTrue() {
		assertTrue(true);
	}
	
	@Test
	public void testCreditandoComSucesso() throws OperacaoIlegalException {
			conta1.creditar(10);
			conta2.creditar(20);
			
			assertEquals(10, conta1.getSaldo(), 0);
			assertEquals(20, conta2.getSaldo(), 0);
	}
	
	
	@Test
	public void testDebitandoComSucesso() throws OperacaoIlegalException {
			conta1.creditar(20);
			conta2.creditar(20);
			
			conta1.debitar(5);
			conta2.debitar(3);
			
			assertEquals(15, conta1.getSaldo(), 0);
			assertEquals(17, conta2.getSaldo(), 0);
	}
	
	
	
	@Test
	public void testTransferindoComSucesso () throws OperacaoIlegalException {
		 conta1.creditar(100);
		 conta1.transferir(conta2, 50);
		  
		 assertEquals(conta2.getSaldo(), 50,0);
	}
	
	
	@Test
	public void testTransferindoValorMaiorQueSaldo() throws OperacaoIlegalException {
		conta1.creditar(100);
		

		
		try {
			conta1.transferir(conta2, 200);
			
			fail("Deveria falhar ao tentar transferir um valor maior do que em caixa");
		} catch (OperacaoIlegalException e) {
			  var expectedException =
			      assertThrows(
			    		  OperacaoIlegalException.class,
			          () -> {
			            throw new OperacaoIlegalException();
			          });
			  assertEquals(e.getMessage(), expectedException.getMessage());
		}
	}
	
	@Test
	public void testTransferindoComValorNegativo() throws OperacaoIlegalException {
		conta1.creditar(100);
		
		try {
			conta1.transferir(conta2, -200);
			
			fail("Deveria falhar ao tentar transferir um valor negativo");
		} catch (OperacaoIlegalException e) {
			  var expectedException =
			      assertThrows(
			    		  OperacaoIlegalException.class,
			          () -> {
			            throw new OperacaoIlegalException();
			          });
			  assertEquals(e.getMessage(), expectedException.getMessage());
		}
	}
	  
	
	
	
	
}
