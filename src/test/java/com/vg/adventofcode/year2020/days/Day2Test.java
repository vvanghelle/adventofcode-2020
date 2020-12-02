package com.vg.adventofcode.year2020.days;


import com.vg.adventofcode.year2020.days.day2.PasswordPolicy1;
import com.vg.adventofcode.year2020.days.day2.PasswordPolicy2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day2Test {

    private Day2 day2;

    @BeforeEach
    public void init() {
        // test should be directly with PasswordPolicy1 or PasswordPolicy2..
        day2 = new Day2(new PasswordPolicy1(), new PasswordPolicy2());
    }

    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");

        String result = day2.computePart1(inputs);

        assertThat(result).isNotNull().isEqualTo("2");
    }

    @Test
    public void computePart2_withEntryList() {
        Stream<String> inputs = Stream.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");

        String result = day2.computePart2(inputs);

        assertThat(result).isNotNull().isEqualTo("1");
    }
}
