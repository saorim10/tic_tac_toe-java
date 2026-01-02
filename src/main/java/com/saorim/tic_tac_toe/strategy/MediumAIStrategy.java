package com.saorim.tic_tac_toe.strategy;

import java.util.Random;

import com.saorim.tic_tac_toe.model.Board;
import com.saorim.tic_tac_toe.model.Player;

public class MediumAIStrategy implements AIStrategy {
	private final EasyAIStrategy easyStrategy = new EasyAIStrategy();
    private final Random random = new Random();
    
    @Override
    public int[] makeMove(Board board, Player aiPlayer) {
        // 50% chance to make a smart move, 50% chance to make a random move
        if (random.nextBoolean()) {
            // Try to win
            int[] winningMove = findWinningMove(board, aiPlayer);
            if (winningMove != null) return winningMove;
            
            // Block opponent
            int[] blockingMove = findWinningMove(board, aiPlayer.getOpponent());
            if (blockingMove != null) return blockingMove;
        }
        
        return easyStrategy.makeMove(board, aiPlayer);
    }
    
    private int[] findWinningMove(Board board, Player player) {
        int size = board.getSize();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.isValidMove(i, j)) {
                    Board testBoard = board.copy();
                    testBoard.makeMove(i, j, player);
                    if (testBoard.checkWinner() == player) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }
}
