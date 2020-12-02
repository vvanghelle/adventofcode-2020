package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.enigmas.enigma2.PasswordEntry;
import com.vg.adventofcode.year2020.enigmas.enigma2.PasswordPolicy;
import com.vg.adventofcode.year2020.utils.LogExecutionTime;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/2
 */
@Component
public class Enigma2 extends AbstractEnigma {

    final PasswordPolicy policy1;
    final PasswordPolicy policy2;

    public Enigma2(
            @Qualifier("passwordPolicy1") PasswordPolicy policy1,
            @Qualifier("passwordPolicy2") PasswordPolicy policy2) {
        this.policy1 = policy1;
        this.policy2 = policy2;
    }

    /**
     * Step 1 : check nb of password are valid with policy nb 1;
     */
    @Override
    @LogExecutionTime
    public String computePart1(Stream<String> inputs) {
        return compute(inputs, policy1::isValid);
    }

    /**
     * Step 2 : check nb of password are valid with policy nb 2;
     */
    @Override
    @LogExecutionTime
    public String computePart2(Stream<String> inputs) {
        return compute(inputs, policy2::isValid);
    }

    private String compute(Stream<String> inputs, Predicate<? super PasswordEntry> policyFilter) {
        List<PasswordEntry> pwds = inputs.map(PasswordEntry::new)
                .filter(policyFilter)
                .collect(Collectors.toList());
        return String.valueOf(pwds.size());
    }

    @Override
    public int getEnigmaDay() {
        return 2;
    }
}
