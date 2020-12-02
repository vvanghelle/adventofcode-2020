package com.vg.adventofcode.year2020;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
public class AdventOfCode implements CommandLineRunner {

    /**
     * Enigma implementation mapped by their bean name (enigma1, enigma2, etc.)
     */
    final Map<String, Enigma> days;

    public static void main(String[] args) {
        SpringApplication.run(AdventOfCode.class, args);
    }

    @Override
    public void run(String... args) {
        for (int i = 1; i <= 25; i++) {
            executeDay(i);
        }
    }

    private void executeDay(int dayNumber) {
        Enigma enigma = days.get("enigma" + dayNumber);
        System.out.println("\n------------------------------\n");
        if (enigma != null) {
            System.out.println("---- AdventOfCode day " + dayNumber + " part 1 : " + enigma.computePart1());
            System.out.println();
            System.out.println("---- AdventOfCode day " + dayNumber + " part 2 : " + enigma.computePart2());
        } else {
            System.out.println("--- No implementation for day " + dayNumber);
        }
    }
}
