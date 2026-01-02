package com.saorim.tic_tac_toe;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saorim.tic_tac_toe.controller.GameController;
import com.saorim.tic_tac_toe.service.GameService;
import com.saorim.tic_tac_toe.view.ConsoleView;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) {
		GameService gameService = new GameService();
        ConsoleView view = new ConsoleView();
        GameController controller = new GameController(gameService, view);
        
        controller.run();
	}

}
