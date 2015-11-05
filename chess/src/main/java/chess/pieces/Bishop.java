package chess.pieces;

import chess.Color;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
	}

	@Override
	public String toString() {
		return "B [" + color + "]";
	}
}
