package chess;

import java.io.File;

import chess.game.Game;
import chess.pgn.Pgn;
import chess.pgn.PgnReader;

public class Main {

	public static void main(String[] args) throws Exception {

		// TODO Apache CLI ?

		PgnReader pgnReader = null;
		Pgn pgn = null;
		Game game;
		if (args.length > 0) {
			pgnReader = new PgnReader();
			pgn = pgnReader.read(new File(args[0]));
			 game = new Game(pgn);
			
		} else { // interactive

			game = new Game();
		}
		game.play();
	}

}
