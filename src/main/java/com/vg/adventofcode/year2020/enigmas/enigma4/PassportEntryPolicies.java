package com.vg.adventofcode.year2020.enigmas.enigma4;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportEntryPolicies {

    public static Predicate<String> yearValidity(int minYear, int maxYear) {
        return v ->
        {
            try {
                int year = Integer.parseInt(v);
                return year >= minYear && year <= maxYear;
            } catch (NumberFormatException e) {
                return false;
            }
        };
    }

    public static Predicate<String> patternValidity(String p) {
        Pattern pattern = Pattern.compile(p);
        return v ->
        {
            Matcher matcher = pattern.matcher(v);
            return matcher.matches();
        };
    }

    public static Predicate<String> exactValue(String... values) {
        List<String> valueList = Arrays.asList(values);
        return valueList::contains;
    }

    public static Predicate<String> digitWithLength(int size) {
        return v -> {
            // parse as long to test if digit.
            try {
                Long.parseLong(v);
                return v.trim().length() == size;
            } catch (NumberFormatException e) {
                return false;
            }
        };
    }

    public static Predicate<String> height(Pair<Integer, Integer> heightInCm, Pair<Integer, Integer> heightInInches) {
        Pattern pattern = Pattern.compile("^([0-9]+)(cm|in)");
        return v ->
        {
            Matcher matcher = pattern.matcher(v);
            if (matcher.matches()) {
                int height = Integer.parseInt(matcher.group(1));
                Pair<Integer, Integer> compareHeight = matcher.group(2).equals("cm") ? heightInCm : heightInInches;
                return height >= compareHeight.getKey() && height <= compareHeight.getValue();
            }
            return false;
        };
    }
}