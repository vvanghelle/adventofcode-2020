package com.vg.adventofcode.year2020.days.day2;

import org.apache.commons.lang3.StringUtils;

public class PasswordWithPolicy {
    private String pwdLine;

    private int minOccurence;
    private int maxOccurence;
    private String charToOccur;
    private String pwd;


    public PasswordWithPolicy(String pwdInput) {
        this.pwdLine = pwdInput;
        this.computePwdLine();
    }

    private void computePwdLine() {
        String[] splittedEntry = this.pwdLine.split(" ");
        String[] occurences = splittedEntry[0].split("-");
        this.minOccurence = Integer.valueOf(occurences[0]);
        this.maxOccurence = Integer.valueOf(occurences[1]);

        this.charToOccur = splittedEntry[1].substring(0, splittedEntry[1].length()-1);

        this.pwd = splittedEntry[2];
    }

    public boolean isValid() {
        int occurence = StringUtils.countMatches(this.pwd, this.charToOccur);
        return occurence >= this.minOccurence && occurence <= this.maxOccurence;
    }
}
