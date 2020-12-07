package com.vg.adventofcode.year2020.enigmas;


import com.vg.adventofcode.year2020.enigmas.enigma7.BagRuleBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Enigma7Test {

    private Enigma7 day7;

    @BeforeEach
    public void init() {
        day7 = new Enigma7(new BagRuleBuilder());
    }

    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags.");

        String result = day7.computePart1(inputs);

        assertThat(result).isNotNull().isEqualTo("4");
    }

    @Test
    public void computePart2_withEntryList() {
        Stream<String> inputs = Stream.of("light red bags contain 1 bright white bag, 2 muted yellow bags.",
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags.",
                "bright white bags contain 1 shiny gold bag.",
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.",
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.",
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags.",
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.",
                "faded blue bags contain no other bags.",
                "dotted black bags contain no other bags.");

        String result = day7.computePart2(inputs);

        assertThat(result).isNotNull().isEqualTo("32");
    }

    @Test
    public void computePart2_withEntryListSecondExample() {
        Stream<String> inputs = Stream.of("shiny gold bags contain 2 dark red bags.",
                "dark red bags contain 2 dark orange bags.",
                "dark orange bags contain 2 dark yellow bags.",
                "dark yellow bags contain 2 dark green bags.",
                "dark green bags contain 2 dark blue bags.",
                "dark blue bags contain 2 dark violet bags.",
                "dark violet bags contain no other bags.");

        String result = day7.computePart2(inputs);

        assertThat(result).isNotNull().isEqualTo("126");
    }
}
