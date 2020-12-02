package com.vg.adventofcode.year2020.days;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2Test {

    private Day2 day2;

    @BeforeEach
    public void init() {
        day2 = new Day2();
    }

    @Test
    public void subMethod() {
        Stream<String> inputs = Stream.of("1721", "979", "366", "299", "675", "1456");

        String result = day2.stubMethod(inputs);

        assertThat(result).isNotNull().isEqualTo("TODO");
    }
}
