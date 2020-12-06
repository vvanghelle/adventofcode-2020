package com.vg.adventofcode.year2020.enigmas.enigma5;

import lombok.Data;

@Data
public class Seat {

    private final String binaryRepresentation;
    private int row;
    private int column;
    private int id;

    public Seat(String binaryRepresentation) {
        this.binaryRepresentation = binaryRepresentation;
        this.computeBinaryRepresentation();
    }

    public Seat(int row, int column) {
        this.binaryRepresentation = null;
        this.row = row;
        this.column = column;
        this.id = row * 8 + column;
    }


    private void computeBinaryRepresentation() {
        String binary = this.binaryRepresentation.replaceAll("F", "0")
                .replaceAll("B", "1")
                .replaceAll("L", "0")
                .replaceAll("R", "1");
        this.row = Integer.parseInt(binary.substring(0,7), 2);
        this.column = Integer.parseInt(binary.substring(7), 2);
        this.id = row * 8 + column;
    }

}
