package com.vg.adventofcode.year2020.enigmas;

import com.vg.adventofcode.year2020.enigmas.enigma5.Seat;
import com.vg.adventofcode.year2020.utils.LogExecutionTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://adventofcode.com/2020/day/5
 */
@Component 
public class Enigma5 extends AbstractEnigma {

    @Override
    @LogExecutionTime
    public String computePart1(Stream<String> inputs) {
        List<Seat> seats = inputs.map(Seat::new).sorted((o1, o2) -> (o2.getId() - o1.getId())).collect(Collectors.toList());
        return String.valueOf(seats.get(0).getId());
    }

    @Override
    @LogExecutionTime
    public String computePart2(Stream<String> inputs) {
        List<Map.Entry<Integer, List<Seat>>> result1 = inputs.map(Seat::new)
                .collect(Collectors.groupingBy(Seat::getRow))
                .entrySet()
                .stream()
                .filter(seatListEntry -> seatListEntry.getValue().size() == 7)
                .collect(Collectors.toList());

        Map.Entry<Integer, List<Seat>> rowMissingBoarding = result1.get(0);

        List<Integer> columns = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7));
        for (Seat seatOnRow : result1.get(0).getValue()){
            columns.remove(columns.indexOf(seatOnRow.getColumn()));
        }

        Seat seat = new Seat(rowMissingBoarding.getKey(), columns.get(0));

        return String.valueOf(seat.getId());
    }

    @Override
    public int getEnigmaDay() {
        return 5;
    }
}
