package chess.pieces;

import chess.Color;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return "Q [" + color + "]";
	}

}
