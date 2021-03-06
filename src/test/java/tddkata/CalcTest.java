package tddkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void testMultipleAdding() {
        int expected = 15;
        int res = calc.sum("1,2,3,4,5");
        assertEquals(expected, res);
    }

    @Test
    public void testMultipleAddingIncorrectDelimiter() {
        int expected = -1;
        int res = calc.sum("1,2,3;4,5");
        assertEquals(expected, res);
    }

    @Test
    public void testMultipleDelimiter() {
        int expected = 3;
        int res = calc.sum("1\n2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectMultipleDelimiter1() {
        int expected = -1;
        int res = calc.sum("1,\n2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectMultipleDelimiter2() {
        int expected = -1;
        int res = calc.sum("1;2\n3");
        assertEquals(expected, res);
    }

    @Test
    public void testCorrectMultipleDelimiter() {
        int expected = 6;
        int res = calc.sum("1\n2,3");
        assertEquals(expected, res);
    }

    @Test
    public void testOneArgIncorrectMultipleDelimiter() {
        int expected = -1;
        int res = calc.sum("1,\n");
        assertEquals(expected, res);
    }

    @Test
    public void testMultipleLineBreaks() {
        int expected = -1;
        int res = calc.sum("1\n\n2");
        assertEquals(expected, res);
    }

    // ?????????? ?? ?????????????????????? ????????????????????????:
    @Test
    public void testCorrectSpecificDelimiter() {
        int expected = 3;
        int res = calc.sum("//^\n1^2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectSpecificDelimiter1() {
        int expected = -1;
        int res = calc.sum("//^\n1^2,3");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectSpecificDelimiter2() {
        int expected = -1;
        int res = calc.sum("//^\1^2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectSpecificDelimiterDoubled() {
        int expected = -1;
        int res = calc.sum("//^\n1^^2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectSpecificDelimiterNoSlash() {
        int expected = -1;
        int res = calc.sum("/^\n1^2");
        assertEquals(expected, res);
    }

    @Test
    public void testIncorrectSpecificDelimiterOneArgOnly() {
        int expected = -1;
        int res = calc.sum("//^\n^2");
        assertEquals(expected, res);
    }

    @Test
    public void throwsExceptionSingle() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calc.sum("-1,2"));
        exception.getMessage().equals("Negatives not allowed -1");
    }

    @Test
    public void throwsExceptionMultiple() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calc.sum("-1,3,-2"));
        exception.getMessage().equals("Negatives not allowed -1,-2");
    }
}
