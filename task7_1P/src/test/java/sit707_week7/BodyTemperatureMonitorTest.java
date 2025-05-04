package sit707_week7;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

public class BodyTemperatureMonitorTest {
	
	TemperatureSensor temperatureSensor = mock(TemperatureSensor.class);
    NotificationSender notificationSender = mock(NotificationSender.class);
    CloudService cloudService = mock(CloudService.class);

    // Create instance of BodyTemperatureMonitor with mocked dependencies
    BodyTemperatureMonitor bodyTemperatureMonitor = new BodyTemperatureMonitor(
    		temperatureSensor,
            cloudService,
            notificationSender
    );

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
	public void testReadTemperatureNegative() {
		when(temperatureSensor.readTemperatureValue()).thenReturn(-1.0);
	}
	
	@Test
	public void testReadTemperatureZero() {
		when(temperatureSensor.readTemperatureValue()).thenReturn(0.0);
	}
	
	@Test
	public void testReadTemperatureNormal() {
		when(temperatureSensor.readTemperatureValue()).thenReturn(36.5);
	}

	@Test
	public void testReadTemperatureAbnormallyHigh() {
		when(temperatureSensor.readTemperatureValue()).thenReturn(40.0);
	}

	/*
	 * CREDIT or above level students, Remove comments. 
	 */
	@Test
	public void testReportTemperatureReadingToCloud() {
	// Mock reportTemperatureReadingToCloud() calls cloudService.sendTemperatureToCloud()
		TemperatureReading temperatureReading = mock(TemperatureReading.class);
		
		// Call the method under test
        bodyTemperatureMonitor.reportTemperatureReadingToCloud(temperatureReading);
        // Verify that sendTemperatureToCloud() is called on cloudService
        verify(cloudService).sendTemperatureToCloud(temperatureReading);
	}
	
	
	/*
	 * CREDIT or above level students, Remove comments. 
	 */
	@Test
	public void testInquireBodyStatusNormalNotification() {
		when(cloudService.queryCustomerBodyStatus(any(Customer.class))).thenReturn("NORMAL");

	    // Call the method under test
	    bodyTemperatureMonitor.inquireBodyStatus();

	    // Verify that sendEmailNotification(Customer, String) is called on notificationSender
	    // Pass any string you want as the second argument
	    verify(notificationSender).sendEmailNotification(any(Customer.class), any(String.class));
	}
	
	/*
	 * CREDIT or above level students, Remove comments. 
	 */
	@Test
	public void testInquireBodyStatusAbnormalNotification() {
		when(cloudService.queryCustomerBodyStatus(any(Customer.class))).thenReturn("ABNORMAL");
        // Call the method under test
        bodyTemperatureMonitor.inquireBodyStatus();
        // Verify that sendEmailNotification(FamilyDoctor) is called on notificationSender
        verify(notificationSender).sendEmailNotification(any(FamilyDoctor.class), any(String.class));
	}
}
