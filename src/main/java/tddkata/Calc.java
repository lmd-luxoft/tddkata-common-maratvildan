package tddkata;

import org.apache.commons.lang3.StringUtils;

public class Calc {
    private static final Integer INCORRECT = -1;

    public int sum(String expression) {
        if (expression == null) {
            return INCORRECT;
        }
        try {
            String[] split = StringUtils.split(expression, ",");
            int sum = 0;
            for (String s : split) {
                sum += Integer.valueOf(s);
            }
            return sum;
        } catch (NumberFormatException e) {
            return INCORRECT;
        }
    }
}
