package com.vg.adventofcode.year2020.enigmas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://adventofcode.com/2020/day/9
 */
public class Enigma9Test {

    private Enigma9 day9;

    @BeforeEach
    public void init() {
        day9 = new Enigma9();
    }

    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of("");

        String result = day9.computePart1(inputs);

        assertThat(result).isNotNull().isEqualTo("todo");
    }

    @Test
    public void computePart2_withEntryList() {
        Stream<String> inputs = Stream.of("");

        String result = day9.computePart2(inputs);

        assertThat(result).isNotNull().isEqualTo("todo");
    }
}
