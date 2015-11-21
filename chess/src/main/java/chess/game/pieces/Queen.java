package chess.game.pieces;

import java.util.List;

import chess.game.Color;
import chess.game.MoveContext;
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
	public String toDetailedString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toAlgebraicRepresentation() {
		return "Q";
	}

	@Override
	public List<Square> reachable(MoveContext moveContext) {
		// TODO Auto-generated method stub
		return null;
	}

}
