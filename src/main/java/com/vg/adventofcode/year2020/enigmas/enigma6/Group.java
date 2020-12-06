package com.vg.adventofcode.year2020.enigmas.enigma6;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Group {

    Set<String> answers;
    private int size;

    public Group() {
        this.size = 0;
        this.answers = new HashSet<>();
    }

    public Group(int size, Set<String> answers) {
        this.size = size;
        this.answers = answers;
    }

    public void addAnswer(String answer) {
        this.answers.add(answer);
    }

    public int getAnsweredResponseSize(){
        return this.answers.size();
    }
}
