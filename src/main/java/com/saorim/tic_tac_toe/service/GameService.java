package com.saorim.tic_tac_toe.service;

import com.saorim.tic_tac_toe.model.Board;
import com.saorim.tic_tac_toe.model.GameState;
import com.saorim.tic_tac_toe.model.Player;
import com.saorim.tic_tac_toe.strategy.AIStrategy;

public class GameService {
	private GameState gameState;
    private AIStrategy aiStrategy;
    private boolean vsComputer;
    
    public GameService() {
        this.gameState = new GameState();
        this.vsComputer = false;
    }
    
    public void startNewGame(boolean vsComputer, String difficulty) {
        this.gameState = new GameState();
        this.vsComputer = vsComputer;
        
        if (vsComputer) {
            setDifficulty(difficulty);
        }
    }
    
    private void setDifficulty(String difficulty) {
        try {
            Class<?> strategyClass = Class.forName(
                "com.jogodavelha.strategy." + difficulty + "AIStrategy"
            );
            this.aiStrategy = (AIStrategy) strategyClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            // Fallback to easy difficulty
            this.aiStrategy = new com.saorim.tic_tac_toe.strategy.EasyAIStrategy();
        }
    }
    
    public boolean makeMove(int row, int col) {
        if (gameState.isGameOver() || !gameState.getBoard().isValidMove(row, col)) {
            return false;
        }
        
        Board board = gameState.getBoard();
        Player currentPlayer = gameState.getCurrentPlayer();
        
        if (board.makeMove(row, col, currentPlayer)) {
            updateGameState();
            
            // AI move if playing against computer and game isn't over
            if (vsComputer && !gameState.isGameOver() && gameState.getCurrentPlayer() == Player.O) {
                makeAIMove();
            }
            
            return true;
        }
        
        return false;
    }
    
    private void makeAIMove() {
        if (aiStrategy != null) {
            Board board = gameState.getBoard();
            Player aiPlayer = gameState.getCurrentPlayer();
            
            int[] move = aiStrategy.makeMove(board, aiPlayer);
            if (move != null) {
                board.makeMove(move[0], move[1], aiPlayer);
                updateGameState();
            }
        }
    }
    
    private void updateGameState() {
        Board board = gameState.getBoard();
        Player winner = board.checkWinner();
        
        if (winner != null) {
            gameState.setGameOver(true);
            gameState.setWinner(winner);
        } else if (board.isFull()) {
            gameState.setGameOver(true);
        } else {
            gameState.setCurrentPlayer(gameState.getCurrentPlayer().getOpponent());
        }
    }
    
    public GameState getGameState() {
        return gameState.copy();
    }
    
    public boolean isVsComputer() {
        return vsComputer;
    }
}
