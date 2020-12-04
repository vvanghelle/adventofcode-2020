package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.enigmas.enigma4.Passport;
import com.vg.adventofcode.year2020.enigmas.enigma4.PassportBuilder;
import com.vg.adventofcode.year2020.enigmas.enigma4.PassportPolicy;
import com.vg.adventofcode.year2020.utils.LogExecutionTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/4
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Enigma4 extends AbstractEnigma {

    @Autowired
    private PassportBuilder builder;

    @Autowired
    @Qualifier("passportPolicy1")
    private PassportPolicy policy1;

    @Autowired
    @Qualifier("passportPolicy2")
    private PassportPolicy policy2;

    @Override
    @LogExecutionTime
    public String computePart1(Stream<String> inputs) {
        List<Passport> passports = builder.getPassports(inputs);
        return String.valueOf(passports.stream().filter(policy1::isValid).count());
    }

    @Override
    @LogExecutionTime
    public String computePart2(Stream<String> inputs) {
        List<Passport> passports = builder.getPassports(inputs);
        return String.valueOf(passports.stream().filter(policy2::isValid).count());
    }

    @Override
    public int getEnigmaDay() {
        return 4;
    }
}
