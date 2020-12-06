package com.vg.adventofcode.year2020.enigmas;


import com.vg.adventofcode.year2020.enigmas.enigma6.FormAnswersBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Enigma6Test {

    private Enigma6 day6;

    @BeforeEach
    public void init() {
        day6 = new Enigma6(new FormAnswersBuilder());
    }

    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of("abc",
                "",
                "a",
                "b",
                "c",
                "",
                "ab",
                "ac",
                "",
                "a",
                "a",
                "a",
                "a",
                "",
                "b");

        String result = day6.computePart1(inputs);

        assertThat(result).isNotNull().isEqualTo("11");
    }

    @Test
    public void computePart2_withEntryList() {
        Stream<String> inputs = Stream.of("abc",
                "",
                "a",
                "b",
                "c",
                "",
                "ab",
                "ac",
                "",
                "a",
                "a",
                "a",
                "a",
                "",
                "b");

        String result = day6.computePart2(inputs);

        assertThat(result).isNotNull().isEqualTo("6");
    }
}
