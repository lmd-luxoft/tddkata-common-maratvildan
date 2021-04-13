package tddkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    Calc calc = new Calc();

    @Test
    public void testNull() {
        int expected = -1;
        int res = calc.sum(null);
        assertEquals(expected, res);
    }

    @Test
    public void testEmpty() {
        int expected = 0;
        int res = calc.sum("");
        assertEquals(expected, res);
    }

    @Test
    public void testOne() {
        int expected = 1;
        int res = calc.sum("1");
        assertEquals(expected, res);
    }

    @Test
    public void testTwoElements() {
        int expected = 3;
        int res = calc.sum("1,2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectNums1() {
        int expected = -1;
        int res = calc.sum("1,a");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectNums2() {
        int expected = -1;
        int res = calc.sum("abc,2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectDelimiter1() {
        int expected = -1;
        int res = calc.sum("1;2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectDelimiter2() {
        int expected = -1;
        int res = calc.sum("1:2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectDelimiterAndNum() {
        int expected = -1;
        int res = calc.sum("1:abc");
        assertEquals(expected, res);
    }
}
