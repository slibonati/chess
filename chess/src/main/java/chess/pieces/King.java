package chess.pieces;

import chess.Color;

public class King extends Piece {

	public King(Color color) {
		super(color);
	}

	@Override
	public String toString() {
		return "K [" + color + "]";
	}
}
