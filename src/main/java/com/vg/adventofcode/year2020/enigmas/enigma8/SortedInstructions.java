package com.vg.adventofcode.year2020.enigmas.enigma8;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class SortedInstructions extends ArrayList<Instruction> {
    private boolean terminatedNormaly;

    public SortedInstructions() {
        super();
        terminatedNormaly = true;
    }
}
