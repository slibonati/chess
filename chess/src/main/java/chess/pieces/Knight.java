package chess.pieces;

import chess.Color;
import chess.Piece;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return "Knight [" + color + "]";
	}

}
