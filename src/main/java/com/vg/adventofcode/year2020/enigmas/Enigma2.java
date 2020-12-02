package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.Enigma;
import com.vg.adventofcode.year2020.enigmas.enigma2.PasswordEntry;
import com.vg.adventofcode.year2020.enigmas.enigma2.PasswordPolicy1;
import com.vg.adventofcode.year2020.enigmas.enigma2.PasswordPolicy2;
import com.vg.adventofcode.year2020.utils.LogExecutionTime;
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
public class Enigma2 implements Enigma {

    final PasswordPolicy1 policy1;
    final PasswordPolicy2 policy2;

    /**
     * Step 1 : check nb of password are valid with policy nb 1;
     */
    @Override
    @LogExecutionTime
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
    @LogExecutionTime
    public String computePart2(Stream<String> inputs) {
        List<PasswordEntry> pwds = inputs.map(PasswordEntry::new)
                .filter(policy2::isValid)
                .collect(Collectors.toList());
        return String.valueOf(pwds.size());
    }
}
