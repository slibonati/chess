package chess.pieces;

import chess.Color;
import chess.Piece;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return "Rook [" + color + "]";
	}


}
