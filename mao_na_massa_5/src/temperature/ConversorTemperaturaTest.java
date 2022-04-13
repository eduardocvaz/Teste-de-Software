package temperature;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

public class ConversorTemperaturaTest {
	
	
	@Before
	public void setUp() {

	}
	
	@Parameter(0)
	public Temperatura entrada;
	@Parameter(1)
	public Temperatura esperado;
	
	@Parameters(name= "{index}: imposto[{0}]={1}")
	public static Object[][] data() throws TempException {
	return new Object[][] {
	{ new Celsius(300), 300 },
	{ 7000, 1050 },
	{ 11000, 2200 },
	{ 4000, 400 },
	{ 8000, 1200 },
	{ 22000, 4400 },
	{ 500, 0 } };
	}
	
	@Test
	public void test() throws TempException {
		assertEquals(esperado, ConversorTemperatura.converte(entrada));
	}
}
