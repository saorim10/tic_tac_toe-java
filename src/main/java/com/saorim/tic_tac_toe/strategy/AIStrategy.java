package com.saorim.tic_tac_toe.strategy;

import com.saorim.tic_tac_toe.model.Board;
import com.saorim.tic_tac_toe.model.Player;

public interface AIStrategy {
	int[] makeMove(Board board, Player aiPlayer);
}
