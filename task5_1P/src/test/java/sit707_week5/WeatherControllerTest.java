package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class WeatherControllerTest {
	private static WeatherController wController;
    private static int nHours;
    private static double[] temperatures;
		
		@BeforeClass
	    public static void setUp() {
	        System.out.println("Setting up...");
	        // Initialize controller
	        wController = WeatherController.getInstance();
	        // Retrieve all the hours temperatures recorded as for today
	        nHours = wController.getTotalHours();
	        temperatures = new double[nHours];
	        for (int i = 0; i < nHours; i++) {
	            temperatures[i] = wController.getTemperatureForHour(i + 1);
	        }
	    }

	    @AfterClass
	    public static void tearDown() {
	        System.out.println("Tearing down...");
	        // Shutdown controller
	        wController.close();
	    }

	@Test
	public void testStudentIdentity() {
		String studentId = "s224047344";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Spandan";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");
        double minTemperature = findMinTemperature();
        Assert.assertEquals(wController.getTemperatureMinFromCache(), minTemperature, 0.01);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");
        double maxTemperature = findMaxTemperature();
        Assert.assertEquals(wController.getTemperatureMaxFromCache(), maxTemperature, 0.01);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");
        double averageTemperature = calculateAverageTemperature();
        Assert.assertEquals(wController.getTemperatureAverageFromCache(), averageTemperature, 0.01);
    }

    private double findMinTemperature() {
        double minTemperature = Double.MAX_VALUE;
        for (double temperature : temperatures) {
            if (temperature < minTemperature) {
                minTemperature = temperature;
            }
        }
        return minTemperature;
    }

    private double findMaxTemperature() {
        double maxTemperature = Double.MIN_VALUE;
        for (double temperature : temperatures) {
            if (temperature > maxTemperature) {
                maxTemperature = temperature;
            }
        }
        return maxTemperature;
    }

    private double calculateAverageTemperature() {
        double sumTemp = 0;
        for (double temperature : temperatures) {
            sumTemp += temperature;
        }
        return sumTemp / nHours;
    }
    
@Test
public void testTemperaturePersist() {
	/*
	 * Remove below comments ONLY for 5.3C task.
	 */
//	System.out.println("+++ testTemperaturePersist +++");
//	
//	// Initialise controller
//	WeatherController wController = WeatherController.getInstance();
//	
//	String persistTime = wController.persistTemperature(10, 19.5);
//	String now = new SimpleDateFormat("H:m:s").format(new Date());
//	System.out.println("Persist time: " + persistTime + ", now: " + now);
//	
//	Assert.assertTrue(persistTime.equals(now));
//	
//	wController.close();
}
}