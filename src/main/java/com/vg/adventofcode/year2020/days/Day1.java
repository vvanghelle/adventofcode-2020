package com.vg.adventofcode.year2020.days;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/1
 *
 */
public class Day1 {

    /**
     * Step 1 get pairs that sum to expected sum.
     */
    public List<Pair<Long, Long>> findPairsThatSumsTo(Stream<String> inputs, int expectedSum) {
        List<Long> inputAsLong = inputs.map(Long::valueOf).collect(Collectors.toList());
        List<Pair<Long, Long>> result = new ArrayList<>();
        for (int i = 0; i< inputAsLong.size(); i++) {
            Long left = inputAsLong.get(i);
            for (int j = i; j< inputAsLong.size(); j++) {
                Long right = inputAsLong.get(j);
                if (left + right == expectedSum) {
                    result.add(Pair.of(left,right));
                }
            }
        }
        return result;
    }

    /**
     * multiply first pair result.
     */
    public Long multiplyPairForExpectedSum(Stream<String> inputs, int expectedSum) {
        List<Pair<Long, Long>> pairs = findPairsThatSumsTo(inputs, expectedSum);
        return (pairs == null || pairs.isEmpty()) ? null : pairs.get(0).getRight() * pairs.get(0).getLeft();
    }
}
