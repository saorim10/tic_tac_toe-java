package com.saorim.tic_tac_toe.view;

import com.saorim.tic_tac_toe.model.GameState;
import com.saorim.tic_tac_toe.model.Player;
import java.util.Scanner;

public class ConsoleView implements GameView {
private final Scanner scanner = new Scanner(System.in);
    
    @Override
    public void displayGame(GameState gameState) {
        clearScreen();
        System.out.println("\n=== JOGO DA VELHA ===\n");
        
        if (gameState.isGameOver()) {
            Player winner = gameState.getWinner();
            if (winner != null) {
                System.out.println("Vencedor: " + winner.getSymbol() + "!");
            } else {
                System.out.println("Empate!");
            }
        } else {
            System.out.println("Vez do jogador: " + gameState.getCurrentPlayer().getSymbol());
        }
        
        System.out.println();
        printBoard(gameState);
        System.out.println();
    }
    
    private void printBoard(GameState gameState) {
        int size = gameState.getBoard().getSize();
        
        // Print column numbers
        System.out.print("   ");
        for (int col = 0; col < size; col++) {
            System.out.print(" " + col + "  ");
        }
        System.out.println();
        
        // Print separator
        System.out.print("   ");
        for (int col = 0; col < size; col++) {
            System.out.print("--- ");
        }
        System.out.println();
        
        // Print rows with row numbers
        for (int row = 0; row < size; row++) {
            System.out.print(row + " |");
            for (int col = 0; col < size; col++) {
                System.out.print(" " + gameState.getBoard().getCell(row, col) + " |");
            }
            System.out.println();
            
            // Print separator between rows
            System.out.print("   ");
            for (int col = 0; col < size; col++) {
                System.out.print("--- ");
            }
            System.out.println();
        }
    }
    
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    @Override
    public void displayError(String error) {
        System.err.println("Erro: " + error);
    }
    
    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    @Override
    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Fallback: print empty lines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    
    public void displayMenu() {
        clearScreen();
        System.out.println("\n=== MENU DO JOGO DA VELHA ===\n");
        System.out.println("1. Jogar contra outro jogador");
        System.out.println("2. Jogar contra o computador (Fácil)");
        System.out.println("3. Jogar contra o computador (Médio)");
        System.out.println("4. Jogar contra o computador (Difícil)");
        System.out.println("5. Sair");
        System.out.print("\nEscolha uma opção: ");
    }
}
