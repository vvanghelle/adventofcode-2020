package com.vg.adventofcode.year2020.enigmas;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Enigma8Test {

    private Enigma8 day8;

    @BeforeEach
    public void init() {
        day8 = new Enigma8();
    }

    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of("");

        String result = day8.computePart1(inputs);

        assertThat(result).isNotNull().isEqualTo("todo");
    }

    @Test
    public void computePart2_withEntryList() {
        Stream<String> inputs = Stream.of("");

        String result = day8.computePart2(inputs);

        assertThat(result).isNotNull().isEqualTo("todo");
    }

}
