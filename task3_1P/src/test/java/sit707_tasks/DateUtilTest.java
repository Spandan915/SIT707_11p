package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
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
	 public void testMaxJanuary15ShouldIncrementToJanuary16() { 
	  // January max boundary area: max+1 
	  DateUtil date = new DateUtil(15, 1, 1994); 
	        System.out.println("january15ShouldIncrementToJanuary16 > " + 
	date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(1, date.getMonth()); 
	        Assert.assertEquals(16, date.getDay()); 
	 } 
	  
	 @Test 
	 public void testNominalJanuary() { 
	  int rand_day_1_to_31 = 1 + new Random().nextInt(31); 
	        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024); 
	        System.out.println("testJanuaryNominal > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	 } 
	  
	  
	 @Test 
	    public void testFebruaryLeapYear() { 
	  DateUtil date = new DateUtil(15, 2, 1994); 
	        System.out.println("feb15ShouldIncrementtToFeb16 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(16, date.getDay()); 
	        Assert.assertEquals(2, date.getMonth()); 
	        Assert.assertEquals(1994, date.getYear()); 
	         
	        date = new DateUtil(28, 2, 2024); 
	        System.out.println("feb28ShouldIncrementtToFeb29 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(29, date.getDay()); 
	        Assert.assertEquals(2, date.getMonth()); 
	        Assert.assertEquals(2024, date.getYear()); 
	         
	        date = new DateUtil(29, 2, 2024); 
	        System.out.println("feb29ShouldIncrementtToMarch1 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(1, date.getDay()); 
	        Assert.assertEquals(3, date.getMonth()); 
	        Assert.assertEquals(2024, date.getYear()); 
	    } 
	  
	 @Test 
	 public void testFebruaryNonLeapYear() { 
	  DateUtil date =  new DateUtil(28, 2, 2023); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(1, date.getDay()); 
	        Assert.assertEquals(3, date.getMonth()); 
	        Assert.assertEquals(2023, date.getYear()); 
	 } 
	  
	    @Test 
	    public void testJune() { 
	        DateUtil date = new DateUtil(1, 6, 1994); 
	        System.out.println("june1ShouldIncrementtToJune2 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(2, date.getDay()); 
	        Assert.assertEquals(6, date.getMonth()); 
	        Assert.assertEquals(1994, date.getYear()); 
	         
	        date = new DateUtil(2, 6, 1994); 
	        System.out.println("june2ShouldIncrementtToJune3 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(3, date.getDay()); 
	        Assert.assertEquals(6, date.getMonth()); 
	        Assert.assertEquals(1994, date.getYear()); 
	         
	        date = new DateUtil(15, 6, 1994); 
	        System.out.println("june15ShouldIncrementtToJune16 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(16, date.getDay()); 
	        Assert.assertEquals(6, date.getMonth()); 
	        Assert.assertEquals(1994, date.getYear()); 
	         
	        date = new DateUtil(30, 6, 1994); 
	        System.out.println("june30ShouldIncrementtToJuly1 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(1, date.getDay()); 
	        Assert.assertEquals(7, date.getMonth()); 
	        Assert.assertEquals(1994, date.getYear()); 
	            
	         
	        date = new DateUtil(15, 6, 1700); 
	        System.out.println("june15ShouldIncrementtToJune16 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(16, date.getDay()); 
	        Assert.assertEquals(6, date.getMonth()); 
	        Assert.assertEquals(1700, date.getYear()); 
	         
	        date = new DateUtil(15, 6, 1701); 
	        System.out.println("june15ShouldIncrementtToJune16 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(16, date.getDay()); 
	        Assert.assertEquals(6, date.getMonth()); 
	        Assert.assertEquals(1701, date.getYear()); 
	         
	         date = new DateUtil(15, 6, 2023); 
	        System.out.println("june15ShouldIncrementtToJune16 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(16, date.getDay()); 
	        Assert.assertEquals(6, date.getMonth()); 
	        Assert.assertEquals(2023, date.getYear()); 
	         
	        date = new DateUtil(15, 6, 2024); 
	        System.out.println("june15ShouldIncrementtToJune16 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(16, date.getDay()); 
	        Assert.assertEquals(6, date.getMonth()); 
	        Assert.assertEquals(2024, date.getYear()); 
	         
	        date = new DateUtil(31, 6, 1994); 
	        System.out.println("Invalid Date: " + date); 
	 
	        // Attempt to increment the date 
	        date.increment(); 
	 
	        // Verify that the date remains unchanged 
	        System.out.println("After Increment: " + date); 
	 
	        // Assert that the day, month, and year components remain the same 
	        Assert.assertEquals(31, date.getDay()); 
	        Assert.assertEquals(6, date.getMonth()); 
	        Assert.assertEquals(1994, date.getYear()); 
	        
	    } 
	     
	    @Test 
	    public void testJuly() { 
	        DateUtil date = new DateUtil(31, 7, 2024); 
	        System.out.println("july31ShouldIncrementtToAugust1 > " + date); 
	        date.increment(); 
	        System.out.println(date); 
	        Assert.assertEquals(1, date.getDay()); 
	        Assert.assertEquals(8, date.getMonth()); 
	        Assert.assertEquals(2024, date.getYear()); 
	    
	    } 
	     
	    @Test 
	    public void testNovember() { 
	     DateUtil date = new DateUtil(15, 11, 1994); 
	System.out.println("november15ShouldIncrementToNovember16 > " + 
	date); 
	date.increment(); 
	System.out.println(date); 
	Assert.assertEquals(16, date.getDay()); 
	Assert.assertEquals(11, date.getMonth()); 
	Assert.assertEquals(1994, date.getYear()); 
	} 
	@Test 
	public void testDecember() { 
	DateUtil date = new DateUtil(15, 12, 1994); 
	System.out.println("decemnber15ShouldIncrementToDecember16 > " + 
	date); 
	date.increment(); 
	System.out.println(date); 
	Assert.assertEquals(16, date.getDay()); 
	Assert.assertEquals(12, date.getMonth()); 
	Assert.assertEquals(1994, date.getYear()); 
	}
}