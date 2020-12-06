package com.vg.adventofcode.year2020.enigmas;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Enigma5Test {

    private Enigma5 day5;

    @BeforeEach
    public void init() {
        day5 = new Enigma5();
    }

    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL");

        String result = day5.computePart1(inputs);

        assertThat(result).isNotNull().isEqualTo("820");
    }

}
