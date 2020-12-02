package com.vg.adventofcode.year2020.days.day2;

import org.apache.commons.lang3.StringUtils;

public class PasswordWithPolicy {
    private String pwdLine;

    private int minOccurence;
    private int maxOccurence;
    private char charToOccur;
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

        this.charToOccur = splittedEntry[1].substring(0, splittedEntry[1].length()-1).charAt(0);

        this.pwd = splittedEntry[2];
    }

    public boolean isValidPolicy1() {
        int occurence = StringUtils.countMatches(this.pwd, this.charToOccur);
        return occurence >= this.minOccurence && occurence <= this.maxOccurence;
    }

    public boolean isValidPolicy2() {
        boolean isPosition1Valid = this.isCharAtPositionValid(this.minOccurence);
        boolean isPosition2Valid = this.isCharAtPositionValid(this.maxOccurence);
        return isPosition1Valid ^ isPosition2Valid;
    }

    private boolean isCharAtPositionValid(int position) {
        try{
            return this.pwd.charAt(position-1) ==  this.charToOccur;
        } catch (StringIndexOutOfBoundsException e ){
            return false;
        }
    }
}
