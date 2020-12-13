package com.vg.adventofcode.year2020.enigmas.enigma8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InstructionListBuilderTest {

    private InstructionListBuilder builder = new InstructionListBuilder();


    @Test()
    void getInstructions_invalidPattern() {
        Stream<String> inputs = Stream.of("TOTO +90");


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            builder.getInstructions(inputs);
        });
    }
    @Test()
    void getInstructions_instructionsValides() {
        Stream<String> inputs = Stream.of("nop +6", "acc -1", "jmp -20");

        List<Instruction> instructions = builder.getInstructions(inputs);
        assertThat(instructions).isNotNull().hasSize(3);
        assertThat(instructions.get(0)).isNotNull();
        assertThat(instructions.get(0).getInstructionType()).isNotNull().isSameAs(InstructionType.nop);
        assertThat(instructions.get(0).getOffset()).isNotNull().isEqualTo(6);
        assertThat(instructions.get(1)).isNotNull();
        assertThat(instructions.get(1).getInstructionType()).isNotNull().isSameAs(InstructionType.acc);
        assertThat(instructions.get(1).getOffset()).isNotNull().isEqualTo(-1);
        assertThat(instructions.get(2)).isNotNull();
        assertThat(instructions.get(2).getInstructionType()).isNotNull().isSameAs(InstructionType.jmp);
        assertThat(instructions.get(2).getOffset()).isNotNull().isEqualTo(-20);
    }
}
