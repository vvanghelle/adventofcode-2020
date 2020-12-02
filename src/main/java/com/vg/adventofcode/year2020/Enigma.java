package com.vg.adventofcode.year2020;

import com.vg.adventofcode.year2020.utils.LogExecutionTime;

import java.util.stream.Stream;

public interface Enigma {

    int getEnigmaDay();

    @LogExecutionTime
    String computePart1();

    @LogExecutionTime
    String computePart2();

    @LogExecutionTime
    String computePart1(Stream<String> inputs);

    @LogExecutionTime
    String computePart2(Stream<String> inputs);
}
