package com.vg.adventofcode.year2020.enigmas.enigma5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeatTest {
    @Test
    void newSeat_shouldBeValid(){
        List<Seat> seats = Arrays.asList(
                new Seat("BFFFBBFRRR"),
                new Seat("FFFBBBFRRR"),
                new Seat("BBFFBBFRLL")
        );

        assertThat(seats.get(0)).isNotNull();
        assertThat(seats.get(0).getRow()).isNotNull().isEqualTo(70);
        assertThat(seats.get(0).getColumn()).isNotNull().isEqualTo(7);
        assertThat(seats.get(0).getId()).isNotNull().isEqualTo(567);

        assertThat(seats.get(1)).isNotNull();
        assertThat(seats.get(1).getRow()).isNotNull().isEqualTo(14);
        assertThat(seats.get(1).getColumn()).isNotNull().isEqualTo(7);
        assertThat(seats.get(1).getId()).isNotNull().isEqualTo(119);

        assertThat(seats.get(2)).isNotNull();
        assertThat(seats.get(2).getRow()).isNotNull().isEqualTo(102);
        assertThat(seats.get(2).getColumn()).isNotNull().isEqualTo(4);
        assertThat(seats.get(2).getId()).isNotNull().isEqualTo(820);
    }
}
