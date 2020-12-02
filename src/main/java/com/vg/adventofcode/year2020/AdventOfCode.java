package com.vg.adventofcode.year2020;

import com.vg.adventofcode.year2020.days.Day1;
import com.vg.adventofcode.year2020.days.Day2;
import com.vg.adventofcode.year2020.days.Day3;
import com.vg.adventofcode.year2020.lib.Puzzle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdventOfCode  implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AdventOfCode.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Puzzle puzzle = new Puzzle();
        executeDay1(puzzle);
        executeDay2(puzzle);
        executeDay3(puzzle);
    }

    private static void executeDay1(Puzzle puzzle) throws Exception {
        Day1 day1 = new Day1();
        String day1File = "day1.txt";

        System.out.println("------------------------------");
        System.out.println("AdventOfCode day 01 part 1 : " + day1.multiplyPairForExpectedSum(puzzle.readInput(day1File), 2020L, 2));
        System.out.println("AdventOfCode day 01 part 2 : " + day1.multiplyPairForExpectedSum(puzzle.readInput(day1File), 2020L, 3));
    }

    private static void executeDay2(Puzzle puzzle) throws Exception {
        Day2 day2 = new Day2();
        String day1File = "day2.txt";

        System.out.println("------------------------------");
        System.out.println("AdventOfCode day 02 part 1 : " + day2.computePart1(puzzle.readInput(day1File)));
        System.out.println("AdventOfCode day 02 part 1 : " + day2.computePart2(puzzle.readInput(day1File)));
    }

    private static void executeDay3(Puzzle puzzle) throws Exception {
        Day3 day3 = new Day3();
        String day1File = "day3.txt";

        System.out.println("------------------------------");
        System.out.println("AdventOfCode day 03 part 1 : " + day3.computePart1(puzzle.readInput(day1File)));
    }
}
