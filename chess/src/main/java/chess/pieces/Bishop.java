package chess.pieces;

import chess.Color;
import chess.Piece;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
	}

	@Override
	public String toString() {
		return "Bishop [" + color + "]";
	}
}
