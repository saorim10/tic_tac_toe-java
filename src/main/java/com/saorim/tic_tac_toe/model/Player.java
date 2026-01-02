package com.saorim.tic_tac_toe.model;

public enum Player {
	X("X"),
    O("O"),
    EMPTY(" ");

    private final String symbol;

    Player(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public Player getOpponent() {
        if (this == X) return O;
        if (this == O) return X;
        return EMPTY;
    }
}
