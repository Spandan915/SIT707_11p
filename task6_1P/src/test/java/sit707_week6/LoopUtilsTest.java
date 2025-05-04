package sit707_week6;
import org.junit.Assert;
import org.junit.Test;
public class LoopUtilsTest {
	 @Test
	    public void testSumUpTo() {
	        Assert.assertEquals(55, LoopUtils.sumUpTo(10)); // Sum of numbers up to 10
	        Assert.assertEquals(5050, LoopUtils.sumUpTo(100)); // Sum of numbers up to 100
	        Assert.assertEquals(0, LoopUtils.sumUpTo(0)); // Edge case: sum of numbers up to 0
	        Assert.assertEquals(1, LoopUtils.sumUpTo(1)); // Edge case: sum of numbers up to 1
	    }
	    
	    @Test
	    public void testIsEven() {
	        Assert.assertTrue(LoopUtils.isEven(4)); // Even number
	        Assert.assertFalse(LoopUtils.isEven(5)); // Odd number
	        Assert.assertTrue(LoopUtils.isEven(0)); // Zero is even
	        Assert.assertFalse(LoopUtils.isEven(-3)); // Negative odd number
	        Assert.assertTrue(LoopUtils.isEven(-6)); // Negative even number
	    }
}


