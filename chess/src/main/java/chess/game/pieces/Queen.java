package chess.game.pieces;

import java.util.List;

import chess.Color;
import chess.game.Square;

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
