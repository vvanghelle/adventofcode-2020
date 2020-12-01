package com.vg.adventofcode.year2020.days;


import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {

    private Day1 day1;

    @BeforeEach
    public void init() {
        day1 = new Day1();
    }

    @Test
    public void findPairsThatSumsTo_shouldReturnCorrectPair() {
        Stream<String> inputs = Stream.of("1721", "979", "366", "299", "675", "1456");

        List<Pair<Long, Long>> pairs = day1.findPairsThatSumsTo(inputs, 2020);

        assertThat(pairs).isNotNull().hasSize(1);
        assertThat(pairs.get(0)).isNotNull();

        List<Long> pairNumber = Arrays.asList(pairs.get(0).getRight(), pairs.get(0).getLeft());
        assertThat(pairNumber).contains(1721l, 299l);
    }

    @Test
    public void multiplyPairForExpectedSum() {
        Stream<String> inputs = Stream.of("1721", "979", "366", "299", "675", "1456");

        Long multiplicationResult = day1.multiplyPairForExpectedSum(inputs, 2020);

        assertThat(multiplicationResult).isNotNull().isEqualTo(514579l);
    }
}
