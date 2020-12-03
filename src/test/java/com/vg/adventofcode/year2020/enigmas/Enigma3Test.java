package com.vg.adventofcode.year2020.enigmas;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Enigma3Test {

    private Enigma3 day3;

    @BeforeEach
    public void init() {
        day3 = new Enigma3();
    }

    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        String result = day3.computePart1(inputs);

        assertThat(result).isNotNull().isEqualTo("7");
    }
    @Test
    public void computePart2_withEntryList() {
        Stream<String> inputs = Stream.of("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        String result = day3.computePart2(inputs);

        assertThat(result).isNotNull().isEqualTo("336");
    }
}
