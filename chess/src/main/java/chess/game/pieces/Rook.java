package chess.game.pieces;

import java.util.List;

import chess.game.Color;
import chess.game.MoveContext;
import chess.game.Square;

public class Rook extends Piece {
	
	private boolean moved;
	
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
	public String toDetailedString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toAlgebraicRepresentation() {
		return "R";
	}

	@Override
	public List<Square> reachable(MoveContext moveContext) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}
}
