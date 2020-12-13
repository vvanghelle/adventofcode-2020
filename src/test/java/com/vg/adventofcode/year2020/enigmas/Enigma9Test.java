package com.vg.adventofcode.year2020.enigmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://adventofcode.com/2020/day/9
 */
public class Enigma9Test {

    private static final String[] NUMBERS = {"35", "20", "15", "25", "47", "40", "62", "55", "65", "95", "102", "117", "150", "182", "127", "219", "299", "277", "309", "576"};
    private Enigma9 day9;

    @BeforeEach
    public void init() {
        day9 = new Enigma9();
    }

    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of(NUMBERS);

        String result = day9.computePart1WithSpecificOffset(inputs, 5);

        assertThat(result).isNotNull().isEqualTo("127");
    }

    @Test
    public void computePart2_withEntryList() {
        Stream<String> inputs = Stream.of(NUMBERS);

        String result = day9.computePart2WithSpecificOffset(inputs, 5);

        assertThat(result).isNotNull().isEqualTo("62");
    }
}
