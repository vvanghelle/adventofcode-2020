package com.vg.adventofcode.year2020.days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/1
 */
public class Day1 {

    /**
     * Step 1 get pairs that sum to expected sum. nbEntriesToSum is >= 2.
     */
    public List<List<Long>> findPairsThatSumsTo(Stream<String> inputs, Long expectedSum, int nbEntriesToSum) {
        List<Long> inputAsLong = inputs.map(Long::valueOf).collect(Collectors.toList());
        return recursiveSumWithSublist(0L, expectedSum, inputAsLong, nbEntriesToSum);
    }

    public List<List<Long>> recursiveSumWithSublist(Long currentSumResult, Long expectedSum, List<Long> remainingEntries, int nbEntriesToSum) {
        if (nbEntriesToSum == 1) {
            // no more recursive call
            List<Long> eligibleEntries = remainingEntries.stream().filter(entry -> (currentSumResult + entry) == expectedSum).collect(Collectors.toList());
            return eligibleEntries.isEmpty() ? Collections.emptyList() : Collections.singletonList(eligibleEntries);
        } else {
            List<List<Long>> result = new ArrayList<>();
            for (int i = 0; i < remainingEntries.size(); i++) {
                Long right = remainingEntries.get(i);
                List<List<Long>> addableEntries = recursiveSumWithSublist(currentSumResult + right,
                        expectedSum,
                        remainingEntries.stream().skip(i + 1).collect(Collectors.toList()),
                        nbEntriesToSum - 1);
                ;
                result.addAll(
                        addableEntries.stream().map(entries -> {
                            List<Long> tmpResult = new ArrayList<>();
                            tmpResult.add(right);
                            tmpResult.addAll(entries);
                            return tmpResult;
                        }).collect(Collectors.toList()));
            }
            return result;
        }

    }

    /**
     * multiply first pair result.
     */
    public Long multiplyPairForExpectedSum(Stream<String> inputs, Long expectedSum, int nbEntriesToSum) {
        List<List<Long>> pairs = findPairsThatSumsTo(inputs, expectedSum, nbEntriesToSum);
        return (pairs == null || pairs.isEmpty()) ? null : pairs.get(0).stream().reduce((l, l2) -> l * l2).get();
    }
}
