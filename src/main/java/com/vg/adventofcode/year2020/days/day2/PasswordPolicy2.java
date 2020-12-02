package com.vg.adventofcode.year2020.days.day2;

import org.springframework.stereotype.Component;

@Component
public class PasswordPolicy2 implements PasswordPolicy{

    @Override
    public boolean isValid(PasswordEntry pwd) {
        boolean isPosition1Valid = this.isCharAtPositionValid(pwd, pwd.getMinOccurence());
        boolean isPosition2Valid = this.isCharAtPositionValid(pwd, pwd.getMaxOccurence());
        return isPosition1Valid ^ isPosition2Valid;
    }

    private boolean isCharAtPositionValid(PasswordEntry pwd, int position) {
        try{
            return pwd.getPwd().charAt(position-1) ==  pwd.getCharToOccur();
        } catch (StringIndexOutOfBoundsException e ){
            return false;
        }
    }
}
