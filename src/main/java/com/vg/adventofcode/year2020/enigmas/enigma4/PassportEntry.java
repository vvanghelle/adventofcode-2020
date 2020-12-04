package com.vg.adventofcode.year2020.enigmas.enigma4;

import lombok.Getter;
import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Predicate;

@Getter
public enum PassportEntry {
    BIRTH_YEAR("byr", PassportEntryPolicies.yearValidity(1920, 2002)),
    ISSUE_YEAR("iyr", PassportEntryPolicies.yearValidity(2010, 2020)),
    EXPIRATION_YEAR("eyr",  PassportEntryPolicies.yearValidity(2020, 2030)),
    HEIGHT("hgt", PassportEntryPolicies.height(Pair.of(150,193), Pair.of(59,76))),
    HAIR_COLOR("hcl", PassportEntryPolicies.patternValidity("^#([a-f0-9]{6}$)")),
    EYE_COLOR("ecl", PassportEntryPolicies.exactValue("amb", "blu","brn", "gry", "grn", "hzl","oth")),
    PASSPORT_ID("pid", PassportEntryPolicies.digitWithLength(9)),
    COUNTRY_ID("cid", null);

    private final String code;
    private final Predicate<String> entryValidity;


    PassportEntry(String code, Predicate<String> entryValidity){
        this.code = code;
        this.entryValidity = entryValidity;
    }

    public static PassportEntry fromCode(String code) {
        for(PassportEntry e : values()) {
            if(e.code.equals(code)) return e;
        }
        throw new IllegalArgumentException("No entry for code : " + code);
    }
}