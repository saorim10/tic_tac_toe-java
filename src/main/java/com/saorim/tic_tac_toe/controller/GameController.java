package com.saorim.tic_tac_toe.controller;

import com.saorim.tic_tac_toe.model.GameState;
import com.saorim.tic_tac_toe.service.GameService;
import com.saorim.tic_tac_toe.view.ConsoleView;
import com.saorim.tic_tac_toe.view.GameView;

public class GameController {
	private final GameService gameService;
    private final GameView view;
    private boolean running;
    
    public GameController(GameService gameService, GameView view) {
        this.gameService = gameService;
        this.view = view;
        this.running = true;
    }
    
    public void run() {
        while (running) {
            showMenu();
        }
        view.displayMessage("Obrigado por jogar!");
    }
    
    private void showMenu() {
        if (view instanceof ConsoleView) {
            ((ConsoleView) view).displayMenu();
            String choice = view.getInput("");
            
            switch (choice) {
                case "1":
                    startGame(false, "Easy");
                    break;
                case "2":
                    startGame(true, "Easy");
                    break;
                case "3":
                    startGame(true, "Medium");
                    break;
                case "4":
                    startGame(true, "Hard");
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    view.displayError("Opção inválida!");
            }
        }
    }
    
    private void startGame(boolean vsComputer, String difficulty) {
        gameService.startNewGame(vsComputer, difficulty);
        gameLoop();
    }
    
    private void gameLoop() {
        while (true) {
            GameState gameState = gameService.getGameState();
            view.displayGame(gameState);
            
            if (gameState.isGameOver()) {
                view.getInput("\nPressione Enter para voltar ao menu...");
                break;
            }
            
            if (gameService.isVsComputer() && gameState.getCurrentPlayer() == com.saorim.tic_tac_toe.model.Player.O) {
                // AI's turn - just display and continue
                try {
                    Thread.sleep(1000); // Pause for visual effect
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                continue;
            }
            
            try {
                String input = view.getInput("Digite linha e coluna (ex: 0 1) ou 'menu' para sair: ");
                
                if (input.equalsIgnoreCase("menu")) {
                    break;
                }
                
                String[] parts = input.split(" ");
                if (parts.length != 2) {
                    view.displayError("Entrada inválida! Use o formato: linha coluna");
                    continue;
                }
                
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                
                if (!gameService.makeMove(row, col)) {
                    view.displayError("Jogada inválida! Tente novamente.");
                }
                
            } catch (NumberFormatException e) {
                view.displayError("Entrada inválida! Use números.");
            }
        }
    }
}
