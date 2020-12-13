package com.vg.adventofcode.year2020.enigmas;


import com.vg.adventofcode.year2020.enigmas.enigma8.Instruction;
import com.vg.adventofcode.year2020.enigmas.enigma8.InstructionListBuilder;
import com.vg.adventofcode.year2020.enigmas.enigma8.InstructionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Enigma8Test {

    private Enigma8 day8;
    private InstructionListBuilder builder;

    @BeforeEach
    public void init()
    {
        builder = new InstructionListBuilder();
        day8 = new Enigma8(builder);
    }

    @Test
    public void sortInstructions_withEntryList() {
        Stream<String> inputs = Stream.of("nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6");

        List<Instruction> sorted = day8.sortInstructions(builder.getInstructions(inputs));

        assertThat(sorted).isNotNull().hasSize(7);
        assertThat(sorted.get(0).getInstructionType()).isNotNull().isSameAs(InstructionType.nop);
        assertThat(sorted.get(1).getInstructionType()).isNotNull().isSameAs(InstructionType.acc);
        assertThat(sorted.get(2).getInstructionType()).isNotNull().isSameAs(InstructionType.jmp);
        assertThat(sorted.get(3).getInstructionType()).isNotNull().isSameAs(InstructionType.acc);
        assertThat(sorted.get(4).getInstructionType()).isNotNull().isSameAs(InstructionType.jmp);
        assertThat(sorted.get(5).getInstructionType()).isNotNull().isSameAs(InstructionType.acc);
        assertThat(sorted.get(6).getInstructionType()).isNotNull().isSameAs(InstructionType.jmp);
    }
    @Test
    public void computePart1_withEntryList() {
        Stream<String> inputs = Stream.of("nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6");

        String result = day8.computePart1(inputs);

        assertThat(result).isNotNull().isEqualTo("5");
    }

    @Test
    public void computePart2_withEntryList() {
        Stream<String> inputs = Stream.of("nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6");

        String result = day8.computePart2(inputs);

        assertThat(result).isNotNull().isEqualTo("8");
    }

}
