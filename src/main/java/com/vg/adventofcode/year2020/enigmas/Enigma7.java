package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.enigmas.enigma7.BagRuleBuilder;
import com.vg.adventofcode.year2020.utils.LogExecutionTime;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/5
 */
@Component
@RequiredArgsConstructor
public class Enigma7 extends AbstractEnigma {

    private final BagRuleBuilder builder;

    @Override
    @LogExecutionTime
    public String computePart1(Stream<String> inputs) {
        Map<String, Map<String, Integer>> colors = builder.getBagColorRules(inputs);
        List<String> searchContainerForBag = Arrays.asList("shiny gold");
        Set<String> possibilities = new HashSet<>();
        while (!searchContainerForBag.isEmpty()){
            Set<String> possibilitiesForCurrentSearch = new HashSet<>();
            for (String searchedColor : searchContainerForBag){
                possibilitiesForCurrentSearch.addAll(colors.entrySet()
                        .stream()
                        .filter(e -> e.getValue().containsKey(searchedColor))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList()));
            }
         //   System.out.println(possibilitiesForCurrentSearch);
            possibilities.addAll(possibilitiesForCurrentSearch);

            searchContainerForBag = new ArrayList<>(possibilitiesForCurrentSearch);
        }
        // System.out.println("--");
        // System.out.println(possibilities);
        return String.valueOf(possibilities.size());
    }

    @Override
    @LogExecutionTime
    public String computePart2(Stream<String> inputs) {
        Map<String, Map<String, Integer>> colors = builder.getBagColorRules(inputs);
        List<String> searchContainedInBag = Arrays.asList("shiny gold");
        Set<String> possibilities = new HashSet<>();
        while (!searchContainedInBag.isEmpty()){
            Set<String> possibilitiesForCurrentSearch = new HashSet<>();
            for (String searchedColor : searchContainedInBag){
                Map<String, Integer> containedBags = colors.get(searchedColor);
            }

            possibilities.addAll(possibilitiesForCurrentSearch);

        }
        return "todo";
    }

    @Override
    public int getEnigmaDay() {
        return 7;
    }
}
