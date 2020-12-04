package com.vg.adventofcode.year2020.enigmas.enigma4;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportPolicy1Test {

    private PassportPolicy1 policy;
    private PassportBuilder builder;

    @BeforeEach
    public void init() {
        policy = new PassportPolicy1();
        builder = new PassportBuilder();
    }

    @Test
    public void isValid_passport1() {
        Stream<String> inputs = Stream.of("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd",
                "byr:1937 iyr:2017 cid:147 hgt:183cm",
                "",
                "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884",
                "hcl:#cfa07d byr:1929",
                "",
                "hcl:#ae17e1 iyr:2013",
                "eyr:2024",
                "ecl:brn pid:760753108 byr:1931",
                "hgt:179cm",
                "",
                "hcl:#cfa07d eyr:2025 pid:166559648",
                "iyr:2011 ecl:brn hgt:59in");
        List<Passport> p = builder.getPassports(inputs);

        assertThat(policy.isValid(p.get(0))).isNotNull().isTrue();
        assertThat(policy.isValid(p.get(1))).isNotNull().isFalse();
        assertThat(policy.isValid(p.get(2))).isNotNull().isTrue();
        assertThat(policy.isValid(p.get(3))).isNotNull().isFalse();
    }
}
