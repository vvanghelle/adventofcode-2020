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
        if (enigma != null) {
            System.out.println("\n------------------------------ AdventOfCode day " + dayNumber + "\n");
            System.out.println("  part 1 result : " + enigma.computePart1());
            System.out.println();
            System.out.println("  part 2 result : " + enigma.computePart2());
        }
    }
}
