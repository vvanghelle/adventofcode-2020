package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.utils.LogExecutionTime;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/3
 */
@Component
public class Enigma3 extends AbstractEnigma {

    @Override
    @LogExecutionTime
    public String computePart1(Stream<String> inputs) {
        List<String> rows = inputs.collect(Collectors.toList());
        return String.valueOf(countTreesWithSlope(rows, 3, 1));
    }

    @Override
    @LogExecutionTime
    public String computePart2(Stream<String> inputs) {
        List<String> rows = inputs.collect(Collectors.toList());
        int[][] slopes = new int[][]{
                new int[]{1, 1},
                new int[]{3, 1},
                new int[]{5, 1},
                new int[]{7, 1},
                new int[]{1, 2}
        };

        long currentMultiplicationResult = 1;

        for (int[] slope : slopes){
            currentMultiplicationResult = currentMultiplicationResult * countTreesWithSlope(rows, slope[0], slope[1]);
        }
        return String.valueOf(currentMultiplicationResult);
    }


    /** Scheme (repetitive on the right)

     ..##.......
     #...#...#..
     .#....#..#.
     ..#.#...#.#
     .#...##..#.
     ..#.##.....
     .#.#.#....#
     .#........#
     #.##...#...
     #...##....#
     .#..#...#.#
     */
    private int countTreesWithSlope(List<String> rows, int right, int down) {
        int i =0, j=0, nbTrees = 0;
        while (j < rows.size())
        {
            // j = row;
            // i = column;
            String row = rows.get(j);
            // repeat scheme on right : modulo
            char currentChar = row.charAt(i % row.length());
            if (currentChar == '#')
                nbTrees++;

            j += down;
            i += right;
        }

        return nbTrees;
    }

    @Override
    public int getEnigmaDay() {
        return 3;
    }
}
