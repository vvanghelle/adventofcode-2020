package com.vg.adventofcode.year2020.enigmas.enigma6;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Component
public class FormAnswersBuilder {

    public List<Group> getGroupAnswers(Stream<String> inputs) {
        List<Group> groupAnswers = new ArrayList<>();
        AtomicReference<Group> currentGroup = new AtomicReference<>(new Group());
        inputs.forEach(input -> {
            if (input.trim().isEmpty()) {
                groupAnswers.add(currentGroup.get());
                currentGroup.set(new Group());
            } else {
                currentGroup.get().addMember();
                for (int i = 0; i < input.length(); i++) {
                    currentGroup.get().addAnswer(String.valueOf(input.charAt(i)));
                }
            }
        });
        groupAnswers.add(currentGroup.get());

        return groupAnswers;
    }

}
