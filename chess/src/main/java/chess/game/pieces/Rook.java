package chess.game.pieces;

import java.util.List;

import chess.Color;
import chess.Square;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
	}
	
	public Rook(Square square, Color color) {
		super(square, color);
	}
	
	@Override
	public String toString() {
		return "R[" + color + "]";
	}

	@Override
	public List<Square> getReachableSquares() {
		// TODO Auto-generated method stub
		return null;
	}


}
