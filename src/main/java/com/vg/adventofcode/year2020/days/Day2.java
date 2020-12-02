package com.vg.adventofcode.year2020.days;

import com.vg.adventofcode.year2020.Day;
import com.vg.adventofcode.year2020.days.day2.PasswordEntry;
import com.vg.adventofcode.year2020.days.day2.PasswordPolicy1;
import com.vg.adventofcode.year2020.days.day2.PasswordPolicy2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/2
 */
@Component
@RequiredArgsConstructor
public class Day2 implements Day {

    final PasswordPolicy1 policy1;
    final PasswordPolicy2 policy2;

    /**
     * Step 1 : check nb of password are valid with policy nb 1;
     */
    @Override
    public String computePart1(Stream<String> inputs) {
        List<PasswordEntry> pwds = inputs.map(PasswordEntry::new)
                .filter(policy1::isValid)
                .collect(Collectors.toList());
        return String.valueOf(pwds.size());
    }

    /**
     * Step 2 : check nb of password are valid with policy nb 2;
     */
    @Override
    public String computePart2(Stream<String> inputs) {
        List<PasswordEntry> pwds = inputs.map(PasswordEntry::new)
                .filter(policy2::isValid)
                .collect(Collectors.toList());
        return String.valueOf(pwds.size());
    }
}
