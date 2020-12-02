package com.vg.adventofcode.year2020.enigmas;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Enigma1Test {

    private Enigma1 day1;

    @BeforeEach
    public void init() {
        day1 = new Enigma1();
    }

    @Test
    public void findPairsThatSumsTo_shouldReturnCorrectPairFor2Entries() {
        Stream<String> inputs = Stream.of("1721", "979", "366", "299", "675", "1456");

        List<List<Long>> pairs = day1.findPairsThatSumsTo(inputs, 2020L, 2);

        assertThat(pairs).isNotNull().hasSize(1);
        assertThat(pairs.get(0)).isNotNull();
        assertThat(pairs.get(0)).contains(1721L, 299L);
    }

    @Test
    public void multiplyPairForExpectedSum_for2Entries() {
        Stream<String> inputs = Stream.of("1721", "979", "366", "299", "675", "1456");

        String multiplicationResult = day1.multiplyPairForExpectedSum(inputs, 2020L, 2);

        assertThat(multiplicationResult).isNotNull().isEqualTo("514579");
    }


    @Test
    public void findPairsThatSumsTo_shouldReturnCorrectPairFor3Entries() {
        Stream<String> inputs = Stream.of("1721", "979", "366", "299", "675", "1456");

        List<List<Long>> pairs = day1.findPairsThatSumsTo(inputs, 2020L, 3);

        assertThat(pairs).isNotNull().hasSize(1);
        assertThat(pairs.get(0)).isNotNull();
        assertThat(pairs.get(0)).contains(979L, 366L, 675L);
    }

    @Test
    public void multiplyPairForExpectedSum_for3Entries() {
        Stream<String> inputs = Stream.of("1721", "979", "366", "299", "675", "1456");

        String multiplicationResult = day1.multiplyPairForExpectedSum(inputs, 2020L, 3);

        assertThat(multiplicationResult).isNotNull().isEqualTo("241861950");
    }
}
