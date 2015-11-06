package chess.pieces;

import chess.Color;
import chess.Square;

public class King extends Piece {

	public King(Color color) {
		super(color);
	}
	
	public King(Square square, Color color) {
		super(square, color);
	}
	
	@Override
	public String toString() {
		return "K[" + color + "]";
	}
}
