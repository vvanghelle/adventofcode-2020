package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.enigmas.enigma8.Instruction;
import com.vg.adventofcode.year2020.enigmas.enigma8.InstructionListBuilder;
import com.vg.adventofcode.year2020.enigmas.enigma8.InstructionType;
import com.vg.adventofcode.year2020.enigmas.enigma8.SortedInstructions;
import com.vg.adventofcode.year2020.utils.LogExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/8
 */
@Component
@RequiredArgsConstructor
public class Enigma8 extends AbstractEnigma {

    private final InstructionListBuilder builder;


    SortedInstructions sortInstructions(List<Instruction> inputs) {
        SortedInstructions sorted = new SortedInstructions();
        int i = 0;
        while (i < inputs.size()) { // while true as loop?
            Instruction instruction = inputs.get(i);
            if (sorted.contains(instruction)) {
                sorted.setTerminatedNormaly(false);
                break;
            }
            switch (inputs.get(i).getInstructionType()) {
                case acc:
                case nop:
                    sorted.add(instruction);
                    i++;
                    break;
                case jmp:
                    sorted.add(instruction);
                    i += instruction.getOffset();
                    break;
            }
        }
        return sorted;
    }

    @Override
    @LogExecutionTime
    public String computePart1(Stream<String> inputs) {
        List<Instruction> instructions = builder.getInstructions(inputs);
        SortedInstructions sortedInstruction = this.sortInstructions(instructions);
        return String.valueOf(calculateResult(sortedInstruction));
    }

    private long calculateResult(SortedInstructions sortedInstruction) {
        long accumulator = 0;
        for (Instruction i : sortedInstruction) {
            switch (i.getInstructionType()) {
                case acc:
                    accumulator += i.getOffset();
            }
        }
        return accumulator;
    }

    @Override
    @LogExecutionTime
    public String computePart2(Stream<String> inputs) {
        List<Instruction> instructions = builder.getInstructions(inputs);

        for (Instruction i : instructions) {
            InstructionType type =  i.getInstructionType();
            switch (type){
                case jmp:
                    i.setInstructionType(InstructionType.nop);
                case nop:
                    i.setInstructionType(InstructionType.nop);
            }
            SortedInstructions sortedInstruction = this.sortInstructions(instructions);
            if(sortedInstruction.isTerminatedNormaly()){
                return String.valueOf(calculateResult(sortedInstruction));
            } else {
                //restore old value
                i.setInstructionType(type);
            }
        }
        return null;
    }

    @Override
    public int getEnigmaDay() {
        return 8;
    }
}
