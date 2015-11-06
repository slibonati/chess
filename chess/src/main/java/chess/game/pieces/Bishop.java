package chess.game.pieces;

import chess.Color;
import chess.Square;

public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
	}
	
	public Bishop(Square square, Color color) {
		super(square, color);
	}
	
	@Override
	public String toString() {
		return "B[" + color + "]";
	}
}
