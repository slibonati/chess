package chess.pieces;

import chess.Color;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
	}
	
	@Override
	public String toString() {
		return "R [" + color + "]";
	}


}
