package com.saorim.tic_tac_toe.strategy;

import com.saorim.tic_tac_toe.model.Board;
import com.saorim.tic_tac_toe.model.Player;

public class HardAIStrategy implements AIStrategy {
	@Override
    public int[] makeMove(Board board, Player aiPlayer) {
        int[] bestMove = minimax(board, aiPlayer, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{bestMove[1], bestMove[2]};
    }
    
    private int[] minimax(Board board, Player player, int depth, int alpha, int beta) {
        Player winner = board.checkWinner();
        
        if (winner == player) {
            return new int[]{10 - depth, -1, -1};
        } else if (winner == player.getOpponent()) {
            return new int[]{depth - 10, -1, -1};
        } else if (board.isFull()) {
            return new int[]{0, -1, -1};
        }
        
        int bestScore = (player == Player.X) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int bestRow = -1;
        int bestCol = -1;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isValidMove(i, j)) {
                    Board newBoard = board.copy();
                    newBoard.makeMove(i, j, player);
                    
                    int[] result = minimax(newBoard, player.getOpponent(), depth + 1, alpha, beta);
                    int score = result[0];
                    
                    if (player == Player.X) {
                        if (score > bestScore) {
                            bestScore = score;
                            bestRow = i;
                            bestCol = j;
                        }
                        alpha = Math.max(alpha, bestScore);
                    } else {
                        if (score < bestScore) {
                            bestScore = score;
                            bestRow = i;
                            bestCol = j;
                        }
                        beta = Math.min(beta, bestScore);
                    }
                    
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
        }
        
        return new int[]{bestScore, bestRow, bestCol};
    }
}
