package com.vg.adventofcode.year2020.enigmas.enigma7;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BagRuleBuilder {
    private final static Pattern COLOR_PATTERN = Pattern.compile("^(.*) bags contain (.*)\\.");
    private final static Pattern CONTAINED_BAGS_PATTERN = Pattern.compile("([0-9]+) ([a-z]+ [a-z]+) bags?[, ]?");

    public Map<String, Map<String, Integer>> getBagColorRules(Stream<String> inputs) {
        return inputs.map(this::parseWithRegex).collect(
                Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    private Map.Entry<String, Map<String, Integer>> parseWithRegex(String s){
        String bagColor = "";
        Map<String, Integer> containedBags = new HashMap<>();

        Matcher colorMatcher = COLOR_PATTERN.matcher(s);
        if (colorMatcher.find()){
            bagColor = colorMatcher.group(1);
            Matcher contentMatcher = CONTAINED_BAGS_PATTERN.matcher(colorMatcher.group(2));
            while(contentMatcher.find()){
                containedBags.put(contentMatcher.group(2), Integer.valueOf(contentMatcher.group(1)));
            }
        }
        return Map.entry(bagColor, containedBags);
    }

}
