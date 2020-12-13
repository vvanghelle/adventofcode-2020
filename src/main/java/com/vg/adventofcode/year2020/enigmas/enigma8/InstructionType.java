package com.vg.adventofcode.year2020.enigmas.enigma8;

public enum InstructionType {
    nop, acc, jmp;

    public static InstructionType fromCode(String code) {
        for(InstructionType e : values()) {
            if(e.toString().equals(code)) return e;
        }
        throw new IllegalArgumentException("No InstructionType for code : " + code);
    }
}
