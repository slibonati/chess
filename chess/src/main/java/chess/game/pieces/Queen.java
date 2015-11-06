package chess.game.pieces;

import chess.Color;
import chess.Square;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
	}
	
	public Queen(Square square, Color color) {
		super(square, color);
	}
	
	
	@Override
	public String toString() {
		return "Q[" + color + "]";
	}

}
