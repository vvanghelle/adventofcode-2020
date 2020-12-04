package com.vg.adventofcode.year2020.enigmas.enigma4;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportPolicy2Test {

    private PassportPolicy2 policy;
    private PassportBuilder builder;

    @BeforeEach
    public void init() {
        policy = new PassportPolicy2();
        builder = new PassportBuilder();
    }

    @Test
    public void isValid_passports_invalid() {
        Stream<String> inputs = Stream.of("eyr:1972 cid:100",
                "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926",
                "",
                "iyr:2019",
                "hcl:#602927 eyr:1967 hgt:170cm",
                "ecl:grn pid:012533040 byr:1946",
                "",
                "hcl:dab227 iyr:2012",
                "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277",
                "",
                "hgt:59cm ecl:zzz",
                "eyr:2038 hcl:74454a iyr:2023",
                "pid:3556412378 byr:2007");
        List<Passport> p = builder.getPassports(inputs);

        assertThat(policy.isValid(p.get(0))).isNotNull().isFalse();
        assertThat(policy.isValid(p.get(1))).isNotNull().isFalse();
        assertThat(policy.isValid(p.get(2))).isNotNull().isFalse();
        assertThat(policy.isValid(p.get(3))).isNotNull().isFalse();
    }
    @Test
    public void isValid_passports_valid() {
        Stream<String> inputs = Stream.of("pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980",
                "hcl:#623a2f",
                "",
                "eyr:2029 ecl:blu cid:129 byr:1989",
                "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm",
                "",
                "hcl:#888785",
                "hgt:164cm byr:2001 iyr:2015 cid:88",
                "pid:545766238 ecl:hzl",
                "eyr:2022",
                "",
                "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719");
        List<Passport> p = builder.getPassports(inputs);

        assertThat(policy.isValid(p.get(0))).isNotNull().isTrue();
        assertThat(policy.isValid(p.get(1))).isNotNull().isTrue();
        assertThat(policy.isValid(p.get(2))).isNotNull().isTrue();
        assertThat(policy.isValid(p.get(3))).isNotNull().isTrue();
    }
}
