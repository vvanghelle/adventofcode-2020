package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.enigmas.enigma6.FormAnswersBuilder;
import com.vg.adventofcode.year2020.enigmas.enigma6.Group;
import com.vg.adventofcode.year2020.utils.LogExecutionTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/6
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Enigma6 extends AbstractEnigma {

    @Autowired
    private FormAnswersBuilder builder;


    @Override
    @LogExecutionTime
    public String computePart1(Stream<String> inputs) {
        List<Group> answers = builder.getGroupAnswers(inputs);
        Optional<Long> sum = answers.stream().map(Group::getAnsweredResponseSize).reduce((size1, size2) -> size1 + size2);
        return String.valueOf(sum.get());
    }

    @Override
    @LogExecutionTime
    public String computePart2(Stream<String> inputs) {
        List<Group> answers = builder.getGroupAnswers(inputs);
        Optional<Long> sum = answers.stream().map(Group::getAllAnsweredResponseSize).reduce((size1, size2) -> size1 + size2);
        return String.valueOf(sum.get());
    }

    @Override
    public int getEnigmaDay() {
        return 6;
    }
}
