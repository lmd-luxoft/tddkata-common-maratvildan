package tddkata;

import org.apache.commons.lang3.StringUtils;

public class Calc {
    private static final Integer INCORRECT = -1;

    public int sum(String expression) {
        if (expression == null) {
            return INCORRECT;
        }
        if (StringUtils.isEmpty(expression)) {
            return 0;
        }
        String regex = "\\d{1,}";
        if (expression.matches(regex)) {
            return Integer.valueOf(expression);
        }
        regex = "\\d{1,},\\d{1,}";
        if (expression.matches(regex)) {
            String[] split = StringUtils.split(expression, ",");
            return Integer.valueOf(split[0]) + Integer.valueOf(split[1]);
        }
        return INCORRECT;
    }
}
