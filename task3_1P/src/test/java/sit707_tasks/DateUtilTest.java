package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

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

    // === Core Date Tests ===

    @Test
    public void testMaxJanuary15ShouldIncrementToJanuary16() {
        DateUtil date = new DateUtil(15, 1, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testNominalJanuary() {
        int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        date.increment();
        Assert.assertTrue(date.getDay() >= 2 && date.getDay() <= 32);
    }

    @Test
    public void testFebruaryLeapYear() {
        DateUtil date = new DateUtil(28, 2, 2024);
        date.increment();
        Assert.assertEquals(29, date.getDay());
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test
    public void testFebruaryNonLeapYear() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test
    public void testJune() {
        DateUtil date = new DateUtil(30, 6, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
    }

    @Test
    public void testJuly() {
        DateUtil date = new DateUtil(31, 7, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
    }

    @Test
    public void testNovember() {
        DateUtil date = new DateUtil(30, 11, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }

    @Test
    public void testDecember() {
        DateUtil date = new DateUtil(31, 12, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
    }

    // === Boundary Value Test Cases for All Months of 2024 ===

    @Test
    public void testJanuary2024Boundary() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testMarch2024Boundary() {
        DateUtil date = new DateUtil(31, 3, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(4, date.getMonth());
    }

    @Test
    public void testApril2024Boundary() {
        DateUtil date = new DateUtil(30, 4, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
    }

    @Test
    public void testMay2024Boundary() {
        DateUtil date = new DateUtil(31, 5, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testJune2024Boundary() {
        DateUtil date = new DateUtil(30, 6, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
    }

    @Test
    public void testJuly2024Boundary() {
        DateUtil date = new DateUtil(31, 7, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
    }

    @Test
    public void testAugust2024Boundary() {
        DateUtil date = new DateUtil(31, 8, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(9, date.getMonth());
    }

    @Test
    public void testSeptember2024Boundary() {
        DateUtil date = new DateUtil(30, 9, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(10, date.getMonth());
    }

    @Test
    public void testOctober2024Boundary() {
        DateUtil date = new DateUtil(31, 10, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(11, date.getMonth());
    }

    @Test
    public void testNovember2024Boundary() {
        DateUtil date = new DateUtil(30, 11, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }

    @Test
    public void testDecember2024Boundary() {
        DateUtil date = new DateUtil(31, 12, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
    }
}
