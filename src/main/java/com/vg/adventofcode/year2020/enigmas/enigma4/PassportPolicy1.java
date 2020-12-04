package com.vg.adventofcode.year2020.enigmas.enigma4;

import org.springframework.stereotype.Component;

@Component
public class PassportPolicy1 implements PassportPolicy {

    @Override
    public boolean isValid(Passport p) {
        int fieldSize = p.getFields().keySet().size();
        return fieldSize == 8 || (fieldSize == 7 && !p.getFields().containsKey(PassportEntry.COUNTRY_ID));
    }
}
