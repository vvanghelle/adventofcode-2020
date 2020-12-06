package com.vg.adventofcode.year2020.enigmas.enigma6;

import lombok.Data;

import java.util.HashMap;

@Data
public class Group {

    HashMap<String, Integer> answers;
    private int size;

    Group() {
        this.size = 0;
        this.answers = new HashMap<>();
    }

    void addAnswer(String answer) {
        int nbAnswer = 0;
        if (this.answers.containsKey(answer)) {
            nbAnswer = this.answers.get(answer);
        }
        this.answers.put(answer, ++nbAnswer);
    }

    void addMember() {
        this.size++;
    }

    public long getAnsweredResponseSize() {
        return this.answers.keySet().size();
    }

    public long getAllAnsweredResponseSize() {
        return this.answers.entrySet()
                .stream()
                .filter(e -> (e.getValue() == this.size))
                .count();
    }
}
