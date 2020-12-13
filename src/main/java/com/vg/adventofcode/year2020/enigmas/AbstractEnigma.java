package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.Enigma;
import com.vg.adventofcode.year2020.enigmas.enigma8.Instruction;
import com.vg.adventofcode.year2020.lib.PuzzleReader;
import com.vg.adventofcode.year2020.utils.LogExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/1
 */
public abstract class AbstractEnigma implements Enigma {

    @Autowired
    PuzzleReader puzzleReader;

    @Override
    @LogExecutionTime
    public String computePart1() {
        return computePart1(puzzleReader.readInput(getEnigmaDay()));
    }

    @Override
    @LogExecutionTime
    public String computePart2() {
        return computePart2(puzzleReader.readInput(getEnigmaDay()));
    }

}
