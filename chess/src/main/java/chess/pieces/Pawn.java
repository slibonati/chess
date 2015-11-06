package chess.pieces;

import chess.Color;
import chess.Square;

public class Pawn extends Piece{

	public Pawn(Color color) {
		super(color);
	}
	
	public Pawn(Square square, Color color) {
		super(square, color);
	}

	@Override
	public String toString() {
		return "P[" + color + "]";
	}

}
