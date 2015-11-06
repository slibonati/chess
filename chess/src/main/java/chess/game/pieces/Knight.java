package chess.game.pieces;

import chess.Color;
import chess.Square;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
	}
	
	public Knight(Square square, Color color) {
		super(square, color);
	}
	
	@Override
	public String toString() {
		return "N[" + color + "]";
	}

}
