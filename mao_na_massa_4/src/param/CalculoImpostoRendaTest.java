package param;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculoImpostoRendaTest {

	@Parameter(0)
	public int entrada;
	@Parameter(1)
	public int esperado;
	
	@Parameters(name= "{index}: imposto[{0}]={1}")
	public static Object[][] data() {
	return new Object[][] {
	{ 3000, 300 },
	{ 7000, 1050 },
	{ 11000, 2200 },
	{ 4000, 400 },
	{ 8000, 1200 },
	{ 22000, 4400 },
	{ 500, 0 } };
	}
	
	
	@Test
	public void test() {
		assertEquals(esperado, CalculoImpostoRenda.calculaImposto(entrada), 0);
	}

}


//* Se  1201 <= valor <= 5000 deve pagar 10% de imposto
//* Se  5001 <= valor <= 10000 deve pagar 15% de imposto
//* Se  valor > 10000 deve pagar 20% de imposto
//* Se  valor < 1201 deve pagar 0% de imposto