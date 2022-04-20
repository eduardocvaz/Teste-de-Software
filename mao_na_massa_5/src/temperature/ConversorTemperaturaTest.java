package temperature;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ConversorTemperaturaTest {
	
	
	@Before
	public void setUp() {
		celcius = new Celsius();
		fahrenheit = new Fahrenheit();
	}

	Temperatura celcius;
	Temperatura fahrenheit;

	@Parameter(0)
	public double entradaC;
	@Parameter(1)
	public double esperadoC;

	@Parameter(2)
	public double entradaF;
	@Parameter(3)
	public double esperadoF;

	@Parameters(name= "{index}: convert[{0}]={1}")
	public static Object[][] data() throws TempException {
	return new Object[][] {
	{ 0, 32, 0 , -17.7778},
	{ 20, 68, 20 , -6.66667 },
	{ 50, 122, 50 , 10 },
	{ 90, 194, 90 , 32.2222 },
	{ 100, 212, 100 , 37.7778 },
	{ 120, 248, 120 , 48.8889 } };
	}
	
	@Test
	public void testCelciusToFahrenheit() throws TempException {
		celcius.setValue(entradaC);
		assertEquals(esperadoC, ConversorTemperatura.converte(celcius).getValue(), 0);
	}

	@Test
	public void testFahrenheitToCelcius() throws TempException {
		fahrenheit.setValue(entradaF);
		assertEquals(esperadoF, ConversorTemperatura.converte(fahrenheit).getValue(), 0.1);
	}




}
