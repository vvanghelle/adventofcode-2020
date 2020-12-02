package com.vg.adventofcode.year2020;

import com.vg.adventofcode.year2020.lib.PuzzleReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class AdventOfCode implements CommandLineRunner {

    final Map<String, Enigma> days;

    public AdventOfCode(Map<String, Enigma> days) {
        this.days = days;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AdventOfCode.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PuzzleReader puzzleReader = new PuzzleReader();
        executeDay(1, puzzleReader);
        executeDay(2, puzzleReader);
        executeDay(3, puzzleReader);
    }

    private void executeDay(int dayNumber, PuzzleReader puzzleReader) throws Exception {
        Enigma enigma = days.get("enigma" + dayNumber);
        String enigmaFile = "enigma" + dayNumber + ".txt";

        System.out.println("------------------------------");
        System.out.println("---- AdventOfCode day " + dayNumber + " part 1 : " + enigma.computePart1(puzzleReader.readInput(enigmaFile)));
        System.out.println("---- AdventOfCode day " + dayNumber + " part 2 : " + enigma.computePart2(puzzleReader.readInput(enigmaFile)));
    }
}
