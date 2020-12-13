package com.vg.adventofcode.year2020.enigmas.enigma8;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InstructionListBuilder {
    private final static Pattern INSTRUCTION_PATTERN = Pattern.compile("^(.*) ([+-]\\d+)");

    public List<Instruction> getInstructions(Stream<String> inputs) {
        return inputs.map(this::parseWithRegex).collect(Collectors.toList());
    }

    private Instruction parseWithRegex(String s) {
        Matcher instructionMatcher = INSTRUCTION_PATTERN.matcher(s);
        if (instructionMatcher.find()) {

            return new Instruction(InstructionType.fromCode(instructionMatcher.group(1)), Long.valueOf(instructionMatcher.group(2)));
        }
        throw new IllegalArgumentException("PATTERN did not match for instruction : " + s);
    }

}
