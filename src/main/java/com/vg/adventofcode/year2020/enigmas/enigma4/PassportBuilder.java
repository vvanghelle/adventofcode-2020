package com.vg.adventofcode.year2020.enigmas.enigma4;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Component
public class PassportBuilder {

    public List<Passport> getPassports(Stream<String> inputs) {
        List<Passport> passports = new ArrayList<>();
        AtomicReference<Passport> p = new AtomicReference<>(new Passport());
        inputs.forEach(input -> {
            if (input.trim().isEmpty())
            {
                passports.add(p.get());
                p.set(new Passport());
            } else {
                String[] params = input.split(" ");
                for (String param : params){
                    String[] keyValue = param.split(":");
                    p.get().setField(keyValue[0], keyValue[1]);
                }
            }
        });
        passports.add(p.get());
        return passports;
    }

}
