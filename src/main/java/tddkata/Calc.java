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
        try {
            String replaced = expression.replace("\n", ",");
            String[] split = StringUtils.split(replaced, ",");
            // проверяем, есть ли подряд идущие разделители, такие как "1,,2" например
            if (StringUtils.countMatches(replaced, ",") + 1 != split.length) {
                return INCORRECT;
            }
            int sum = 0;
            for (String s : split) {
                sum += Integer.parseInt(s);
            }
            return sum;
        } catch (NumberFormatException e) {
            return INCORRECT;
        }
    }
}
