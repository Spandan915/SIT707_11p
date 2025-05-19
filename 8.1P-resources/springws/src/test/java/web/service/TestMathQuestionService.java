package web.service;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {

	@Test
	public void testTrueAdd() {
		Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
	}

	
	@Test
    public void testNegativeNumberAddition() {
        // Test adding negative numbers
        Assert.assertEquals(MathQuestionService.q1Addition("-5", "-3"), -8, 0);
    }

    @Test
    public void testDecimalNumberAddition() {
        // Test adding decimal numbers
        Assert.assertEquals(MathQuestionService.q1Addition("3.5", "2.5"), 6.0, 0);
    }


    @Test
    public void testLargeNumberAddition() {
        // Test adding large numbers
        Assert.assertEquals(MathQuestionService.q1Addition("1000000000", "2000000000"), 3000000000L, 0);
    }


    @Test
    public void testBoundaryValues() {
        // Test adding numbers at boundary values
        Assert.assertEquals(MathQuestionService.q1Addition(Integer.MAX_VALUE + "", "1"), Integer.MAX_VALUE + 1L, 0);
        Assert.assertEquals(MathQuestionService.q1Addition(Integer.MIN_VALUE + "", "-1"), Integer.MIN_VALUE - 1L, 0);
    }
    
    @Test
    public void testQ1AdditionWithValidInput() {
        // Test with valid input numbers
        double result = MathQuestionService.q1Addition("5", "3");
        Assert.assertEquals(8, result, 0);
    }

    @Test
    public void testQ1AdditionWithNegativeNumbers() {
        // Test with negative numbers
        double result = MathQuestionService.q1Addition("-5", "3");
        Assert.assertEquals(-2, result, 0);
    }

    @Test
    public void testQ2SubtractionWithValidInput() {
        // Test with valid input numbers
        double result = MathQuestionService.q2Subtraction("10", "3");
        Assert.assertEquals(7, result, 0);
    }
    
    @Test
    public void testQ1AdditionWithDecimalNumbers() {
        // Test with decimal numbers
        double result = MathQuestionService.q1Addition("2.5", "3.5");
        Assert.assertEquals(6.0, result, 0);
    }

    @Test
    public void testQ1AdditionWithLargeNumbers() {
        // Test with large numbers
        double result = MathQuestionService.q1Addition("1000000000", "2000000000");
        Assert.assertEquals(3000000000.0, result, 0);
    }

    @Test
    public void testQ1AdditionWithInvalidInput() {
        // Test with invalid input (non-numeric characters)
        double result = MathQuestionService.q1Addition("abc", "def");
        Assert.assertTrue(Double.isNaN(result)); // Expect NaN (Not a Number)
    }

    @Test
    public void testQ1AdditionWithEmptyInput() {
        // Test with empty input
    	Assert.assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "")));
    }
    
    @Test
    public void testQ2SubtractionWithDecimalNumbers() {
        // Test with decimal numbers
        double result = MathQuestionService.q2Subtraction("5.5", "2.5");
        Assert.assertEquals(3.0, result, 0);
    }

    @Test
    public void testQ2SubtractionWithLargeNumbers() {
        // Test with large numbers
        double result = MathQuestionService.q2Subtraction("2000000000", "1000000000");
        Assert.assertEquals(1000000000.0, result, 0);
    }

    @Test
    public void testQ2SubtractionWithInvalidInput() {
        // Test with invalid input (non-numeric characters)
        double result = MathQuestionService.q2Subtraction("abc", "def");
        Assert.assertTrue(Double.isNaN(result)); // Expect NaN (Not a Number)
    }

    @Test
    public void testQ2SubtractionWithEmptyInput() {
        // Test with empty input
    	Assert.assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("", "")));
    }

}