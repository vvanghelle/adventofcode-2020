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

    public Map<String, Map<String, Integer>> getBagColorRules(Stream<String> inputs) {
        return inputs
                .collect(Collectors.toMap((r) -> r.substring(0, r.indexOf("bags")).trim(), r -> r))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        en -> parseContent(en.getValue())));
    }

    private Map<String, Integer> parseContent(String r) {
        Map<String, Integer> container = new HashMap<>();
        Pattern pattern = Pattern.compile("^([0-9]+) ([a-z]+ [a-z]+) bags?\\.?");

        String sub = r.substring(r.indexOf("contain ")+8);
        String[] contained = sub.split(", ");

        for (int i = 0; i < contained.length; i++){
            Matcher m = pattern.matcher(contained[i]);
            if (m.find()){
                container.put(m.group(2), Integer.parseInt(m.group(1)));
            }
        }
        return container;
    }

}
