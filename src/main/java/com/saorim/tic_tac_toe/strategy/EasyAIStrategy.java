package com.saorim.tic_tac_toe.strategy;

import java.util.Random;

import com.saorim.tic_tac_toe.model.Board;
import com.saorim.tic_tac_toe.model.Player;

public class EasyAIStrategy implements AIStrategy {
	private final Random random = new Random();
    
    @Override
    public int[] makeMove(Board board, Player aiPlayer) {
        int size = board.getSize();
        int row, col;
        
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (!board.isValidMove(row, col));
        
        return new int[]{row, col};
    }
}
