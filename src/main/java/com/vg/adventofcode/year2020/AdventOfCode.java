package com.vg.adventofcode.year2020;

import com.vg.adventofcode.year2020.lib.Puzzle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class AdventOfCode implements CommandLineRunner {

    final Map<String, Day> days;

    public AdventOfCode(Map<String, Day> days) {
        this.days = days;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AdventOfCode.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Puzzle puzzle = new Puzzle();
        executeDay(1, puzzle);
        executeDay(2, puzzle);
        executeDay(3, puzzle);
    }

    private void executeDay(int dayNumber, Puzzle puzzle) throws Exception {
        Day day = days.get("day" + dayNumber);
        String dayFile = "day" + dayNumber + ".txt";

        System.out.println("------------------------------");
        System.out.println("AdventOfCode day " + dayNumber + " part 1 : " + day.computePart1(puzzle.readInput(dayFile)));
        System.out.println("AdventOfCode day " + dayNumber + " part 2 : " + day.computePart2(puzzle.readInput(dayFile)));
    }
}
