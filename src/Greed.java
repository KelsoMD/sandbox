import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static java.util.Collections.singletonMap;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Greed {

    private static final Map<Map<Integer, Integer>, Integer> scoreMap = new HashMap<>();

    static {
        scoreMap.put(singletonMap(1, 3), 1000);
        scoreMap.put(singletonMap(2, 3), 200);
        scoreMap.put(singletonMap(3, 3), 300);
        scoreMap.put(singletonMap(4, 3), 400);
        scoreMap.put(singletonMap(5, 3), 500);
        scoreMap.put(singletonMap(6, 3), 600);
        scoreMap.put(singletonMap(1, 1), 100);
        scoreMap.put(singletonMap(5, 1), 50);
    }

    public static int greedy(int[] dice) {
        return stream(dice).boxed().collect(groupingBy(identity(), counting())).entrySet().stream()
                .map(entry -> calcScore(entry.getKey(), entry.getValue())).mapToInt(Integer::intValue).sum();
    }

    private static int calcScore(int number, long totalCount) {

        int score = 0;
        long currentCount = totalCount;
        while (currentCount > 0) {
            if (currentCount >= 3) {
                Integer value = scoreMap.get(singletonMap(number, 3));
                score = score + (null == value ? 0 : value);
                currentCount = currentCount - 3;
            } else {
                Integer value = scoreMap.get(singletonMap(number, 1));
                score = score + (null == value ? 0 : value);
                currentCount--;
            }
        }
        return score;
    }
}