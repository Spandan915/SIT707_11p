package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "s224047344";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Spandan Das";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testWeatherAdvice_AllClear() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(40.0, 0.0)); // Normal conditions
    }

    @Test
    public void testWeatherAdvice_Cancel() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(80.0, 7.0)); // Dangerous conditions
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 5.0)); // Concerning conditions
    }

    @Test
    public void testWeatherAdvice_Warn() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 0.0)); // Wind speed above CONCERNING_WINDSPEED
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(0.0, 5.0)); // Precipitation above CONCERNING_RAINFALL
    }
    
    @Test
    public void testIsPrime_PrimeNumber() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(5));
    }

    @Test
    public void testIsPrime_NotPrimeNumber() {
        Assert.assertFalse(WeatherAndMathUtils.isPrime(4));
    }

    @Test
    public void testIsPrime_One() {
        Assert.assertTrue(WeatherAndMathUtils.isPrime(1)); // 1 is considered prime in this implementation
    }


}