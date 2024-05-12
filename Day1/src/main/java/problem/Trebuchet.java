package problem;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static utils.Utils.readFile;


public class Trebuchet {


    Integer lowestAdventDigit(String str, Map<String, Integer> digits) {
        var lowestDigit = 0;
        var remaining = str;
        for (var patternAndDigit : digits.entrySet()) {
            var index = remaining.indexOf(patternAndDigit.getKey());
            if (index > -1) {
                remaining = remaining.substring(0, index + patternAndDigit.getKey().length());
                lowestDigit = patternAndDigit.getValue();
            }


        }
        return lowestDigit;
    }

    Integer highestAdventDigit(String str, Map<String, Integer> digits) {
        var lowestDigit = 0;
        var remaining = str;
        for (var patternAndDigit : digits.entrySet()) {
            var index = remaining.lastIndexOf(patternAndDigit.getKey());
            if (index > -1) {
                remaining = remaining.substring(index);
                lowestDigit = patternAndDigit.getValue();
            }


        }
        return lowestDigit;
    }


    Map<String, Integer> digits = new HashMap<>() {
        {
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
            put("1", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
        }
    };


    public Integer problem1(String filePath) {
        var numericPatterns = digits.entrySet().stream().filter(e -> StringUtils.isNumeric(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        List<String> lines = readFile(filePath);
        var result = lines
                .stream()
                .map(line -> lowestAdventDigit(line, numericPatterns) * 10 + highestAdventDigit(line, numericPatterns))
                .mapToInt(Integer::intValue).sum();
        return result;
    }

    public Integer problem2(String filePath) {
        List<String> lines = readFile(filePath);
        return lines.stream().map(line -> lowestAdventDigit(line, digits) * 10 + highestAdventDigit(line, digits))
                .mapToInt(Integer::intValue).sum();
    }
}