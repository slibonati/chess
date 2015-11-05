package chess.pieces;

import chess.Color;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return "N [" + color + "]";
	}

}
