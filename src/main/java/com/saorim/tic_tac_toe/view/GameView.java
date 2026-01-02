package com.saorim.tic_tac_toe.view;

import com.saorim.tic_tac_toe.model.GameState;

public interface GameView {
	void displayGame(GameState gameState);
    void displayMessage(String message);
    void displayError(String error);
    String getInput(String prompt);
    void clearScreen();
}
