package chess.game.pieces;

import java.util.List;

import chess.game.Color;
import chess.game.MoveContext;
import chess.game.Square;

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

	@Override
	public String toDetailedString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toAlgebraicRepresentation() {
		return "K";
	}

	@Override
	public List<Square> reachable(MoveContext moveContext) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
