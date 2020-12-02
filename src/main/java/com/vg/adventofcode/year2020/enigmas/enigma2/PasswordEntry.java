package com.vg.adventofcode.year2020.enigmas.enigma2;

import lombok.Getter;

@Getter
public class PasswordEntry {
    private final String pwdLine;

    private int minOccurence;
    private int maxOccurence;
    private char charToOccur;
    private String pwd;


    public PasswordEntry(String pwdInput) {
        this.pwdLine = pwdInput;
        this.computePwdLine();
    }

    private void computePwdLine() {
        String[] splittedEntry = this.pwdLine.split(" ");
        String[] occurences = splittedEntry[0].split("-");
        this.minOccurence = Integer.parseInt(occurences[0]);
        this.maxOccurence = Integer.parseInt(occurences[1]);

        this.charToOccur = splittedEntry[1].substring(0, splittedEntry[1].length() - 1).charAt(0);

        this.pwd = splittedEntry[2];
    }
}
