package com.vg.adventofcode.year2020.enigmas.enigma4;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Passport {
    private final Map<PassportEntry, String> fields;

    public Passport(){
        this.fields = new HashMap<>();
    }

    public void setField(String field, String value){
        this.fields.put(PassportEntry.fromCode(field), value);
    }
}
