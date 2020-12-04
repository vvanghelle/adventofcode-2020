package com.vg.adventofcode.year2020.enigmas.enigma4;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Predicate;

@Component
public class PassportPolicy2 implements PassportPolicy {

    @Override
    public boolean isValid(Passport p) {
        int fieldSize = p.getFields().keySet().size();
        return (fieldSize == 8
                || (fieldSize == 7 && !p.getFields().containsKey(PassportEntry.COUNTRY_ID)))
                && isFieldsValid(p.getFields());
    }

    private boolean isFieldsValid(Map<PassportEntry, String> fields) {
        long nbValidFields = fields.entrySet().stream().filter(entry -> {
            Predicate<String> entryPolicy = entry.getKey().getEntryValidity();
            return entryPolicy == null
                    || entryPolicy.test(entry.getValue());
        }).count();
        return fields.size() == nbValidFields;
    }
}
