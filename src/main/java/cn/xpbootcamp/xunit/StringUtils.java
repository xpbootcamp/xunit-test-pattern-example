package cn.xpbootcamp.xunit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringUtils {
    public static Map<Character, Integer> countChar(String source) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        char[] chars = source.toCharArray();
        Arrays.sort(chars);
        for (char aChar : chars) {
            Integer currentSum = result.getOrDefault(aChar, 0);
            result.put(aChar, currentSum + 1);
        }
        return result;
    }
}