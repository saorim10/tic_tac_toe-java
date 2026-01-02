package com.saorim.tic_tac_toe.model;

public class Cell {
	private int row;
    private int col;
    private Player value;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.value = Player.EMPTY;
    }

    public boolean isEmpty() {
        return value == Player.EMPTY;
    }

    public void setValue(Player value) {
        this.value = value;
    }

    public Player getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return value.getSymbol();
    }
}
