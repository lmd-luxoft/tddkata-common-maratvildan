package tddkata;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

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
            char possibleDelims = '\n';
            if (expression.startsWith("//") && expression.length() > 4 && expression.indexOf("\n") == 3) {
                possibleDelims = expression.charAt(2);
                expression = expression.substring(4);
                // запятая уже не валидна:
                if (expression.contains(",")) {
                    return INCORRECT;
                }
            }
            String replaced = expression.replace(String.valueOf(possibleDelims), ",");
            String[] split = replaced.split(",");
            // проверяем, есть ли подряд идущие разделители, такие как "1,,2" например
            if (StringUtils.countMatches(replaced, ",") + 1 != split.length) {
                return INCORRECT;
            }
            int sum = 0;
            List<Integer> list = new ArrayList<>();
            for (String s : split) {
                int i = Integer.parseInt(s);
                if (i < 0) {
                    list.add(i);
                }
                sum += i;
            }
            if (!list.isEmpty()) {
                throw new IllegalArgumentException("Negatives not allowed " + StringUtils.joinWith(", ", list));
            }
            return sum;
        } catch (NumberFormatException e) {
            return INCORRECT;
        }
    }
}
