package tddkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {

    @Test
    public void test() {
        Calc calc = new Calc();

        int res = calc.sum("");
        assertEquals(0, res);

        res = calc.sum("1");
        assertEquals(1, res);

        res = calc.sum("1,2");
        assertEquals(3, res);
    }
}
