package com.vg.adventofcode.year2020.enigmas.enigma8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Instruction {
    private InstructionType instructionType;
    private long offset;
}
