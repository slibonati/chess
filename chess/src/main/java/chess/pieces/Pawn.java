package chess.pieces;

import chess.Color;
import chess.Piece;

public class Pawn extends Piece{

	public Pawn(Color color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return "Pawn [" + color + "]";
	}

}
