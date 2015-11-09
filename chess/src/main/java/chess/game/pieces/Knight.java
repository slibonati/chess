package chess.game.pieces;

import java.util.List;

import chess.Color;
import chess.game.Square;

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

	@Override
	public List<Square> getReachableSquares() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toDetailedString() {
		// TODO Auto-generated method stub
		return null;
	}

}
