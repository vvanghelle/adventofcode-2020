package com.vg.adventofcode.year2020.days.day2;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class PasswordPolicy1 implements PasswordPolicy{
    @Override
    public boolean isValid(PasswordEntry pwd) {
        int occurence = StringUtils.countMatches(pwd.getPwd(), pwd.getCharToOccur());
        return occurence >= pwd.getMinOccurence() && occurence <= pwd.getMaxOccurence();
    }
}
