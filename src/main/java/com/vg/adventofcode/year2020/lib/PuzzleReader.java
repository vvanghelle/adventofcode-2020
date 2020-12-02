package com.vg.adventofcode.year2020.lib;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PuzzleReader {

    public Stream<String> readInput(int day) {
        try {
            return readInput("enigma" + day + ".txt");
        } catch (IOException | NullPointerException e) {
            return Stream.empty();
        }
    }

    public Stream<String> readInput(String filename) throws IOException, NullPointerException {
        InputStream inputStream = PuzzleReader.class.getClassLoader().getResourceAsStream(filename);
        if (inputStream != null) { // this means you are inside a fat-jar / container
            try (
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
            ) {
                List<String> lines = bufferedReader.lines().collect(Collectors.toList());
                return lines.stream();
            }
        } else {
            String path = this.getClass().getResource(filename).getPath();
            return Files.lines(Paths.get(path));
        }

    }
}
