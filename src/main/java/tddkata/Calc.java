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
            String possibleDelims = "\n";
            if (expression.startsWith("//") && expression.indexOf("\n") == 3) {
                possibleDelims = String.valueOf(expression.charAt(2));
                expression = expression.substring(4);
                // запятая уже не валидна:
                if (expression.contains(",")) {
                    return INCORRECT;
                }
            }
            String replaced = expression.replace(possibleDelims, ",");
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
