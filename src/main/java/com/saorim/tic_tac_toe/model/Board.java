package com.saorim.tic_tac_toe.model;

public class Board {
	private static final int SIZE = 3;
    private final Cell[][] cells;

    public Board() {
        cells = new Cell[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean makeMove(int row, int col, Player player) {
        if (isValidMove(row, col)) {
            cells[row][col].setValue(player);
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && 
               col >= 0 && col < SIZE && 
               cells[row][col].isEmpty();
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public Player checkWinner() {
        // Check rows
        for (int i = 0; i < SIZE; i++) {
            if (cells[i][0].getValue() != Player.EMPTY &&
                cells[i][0].getValue() == cells[i][1].getValue() &&
                cells[i][1].getValue() == cells[i][2].getValue()) {
                return cells[i][0].getValue();
            }
        }

        // Check columns
        for (int j = 0; j < SIZE; j++) {
            if (cells[0][j].getValue() != Player.EMPTY &&
                cells[0][j].getValue() == cells[1][j].getValue() &&
                cells[1][j].getValue() == cells[2][j].getValue()) {
                return cells[0][j].getValue();
            }
        }

        // Check diagonals
        if (cells[0][0].getValue() != Player.EMPTY &&
            cells[0][0].getValue() == cells[1][1].getValue() &&
            cells[1][1].getValue() == cells[2][2].getValue()) {
            return cells[0][0].getValue();
        }

        if (cells[0][2].getValue() != Player.EMPTY &&
            cells[0][2].getValue() == cells[1][1].getValue() &&
            cells[1][1].getValue() == cells[2][0].getValue()) {
            return cells[0][2].getValue();
        }

        return null;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int getSize() {
        return SIZE;
    }

    public Board copy() {
        Board copy = new Board();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                copy.cells[i][j].setValue(this.cells[i][j].getValue());
            }
        }
        return copy;
    }
}
