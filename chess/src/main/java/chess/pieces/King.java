package chess.pieces;

import chess.Color;
import chess.Piece;

public class King extends Piece {

	public King(Color color) {
		super(color);
	}

	@Override
	public String toString() {
		return "King [" + color + "]";
	}
}
