package tddkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {

    @Test
    public void testEmpty() {
        Calc calc = new Calc();

        int res = calc.sum("");
        assertEquals(0, res);
    }

    @Test
    public void testOne() {
        Calc calc = new Calc();

        int res = calc.sum("1");
        assertEquals(1, res);
    }

    @Test
    public void testTwoElements() {
        Calc calc = new Calc();

        int res = calc.sum("1,2");
        assertEquals(3, res);
    }

    @Test
    public void testIncorrectNums1() {
        Calc calc = new Calc();

        int res = calc.sum("1,a");
        assertEquals(-1, res);
    }

    @Test
    public void testIncorrectNums2() {
        Calc calc = new Calc();

        int res = calc.sum("abc,2");
        assertEquals(-1, res);
    }

    @Test
    public void testIncorrectDelimiter1() {
        Calc calc = new Calc();

        int res = calc.sum("1;2");
        assertEquals(-1, res);
    }

    @Test
    public void testIncorrectDelimiter2() {
        Calc calc = new Calc();

        int res = calc.sum("1:2");
        assertEquals(-1, res);
    }

    @Test
    public void testIncorrectDelimiterAndNum() {
        Calc calc = new Calc();

        int res = calc.sum("1:abc");
        assertEquals(-1, res);
    }
}
