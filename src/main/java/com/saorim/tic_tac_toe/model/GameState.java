package com.saorim.tic_tac_toe.model;

public class GameState {
	private final Board board;
    private Player currentPlayer;
    private boolean gameOver;
    private Player winner;
    
    public GameState() {
        this.board = new Board();
        this.currentPlayer = Player.X;
        this.gameOver = false;
        this.winner = null;
    }
    
    public GameState(Board board, Player currentPlayer, boolean gameOver, Player winner) {
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.gameOver = gameOver;
        this.winner = winner;
    }
    
    // Getters e Setters
    public Board getBoard() {
        return board;
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    public Player getWinner() {
        return winner;
    }
    
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    
    public GameState copy() {
        return new GameState(
            board.copy(),
            currentPlayer,
            gameOver,
            winner
        );
    }
}
