package chess.pieces;

import chess.Color;
import chess.Piece;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return "Queen [" + color + "]";
	}

}
