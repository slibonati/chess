package chess;

import chess.game.Game;

public class Main {



	public static void main(String[] args) {

		Game game = new Game();
		game.getBoard().show();
		
		game.play();
		
	}

}
