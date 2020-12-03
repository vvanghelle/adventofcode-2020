package com.vg.adventofcode.year2020.enigmas;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Enigma4Test {

    private Enigma4 day4;

    @BeforeEach
    public void init() {
        day4 = new Enigma4();
    }

    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of("");

        String result = day4.computePart1(inputs);

        assertThat(result).isNotNull().isEqualTo("todo");
    }
    @Test
    public void computePart2_withEntryList() {
        Stream<String> inputs = Stream.of("");

        String result = day4.computePart2(inputs);

        assertThat(result).isNotNull().isEqualTo("todo");
    }
}
