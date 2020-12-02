package com.vg.adventofcode.year2020.days;

import com.vg.adventofcode.year2020.days.day2.PasswordWithPolicy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/2
 */
public class Day2 {

    /**
     * Step 1
     */
    public int computePart1(Stream<String> inputs) {
        List<PasswordWithPolicy> pwds = inputs.map(PasswordWithPolicy::new)
                .filter(PasswordWithPolicy::isValid)
                .collect(Collectors.toList());
        return pwds.size();
    }
}
