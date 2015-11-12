package chess.game.pieces;

import java.util.List;

import chess.game.Color;
import chess.game.MoveContext;
import chess.game.Square;

public class King extends Piece {

	private boolean castled;
	private boolean moved;
	
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

	public boolean isCastled() {
		return castled;
	}

	public void setCastled(boolean castled) {
		this.castled = castled;
	}

	public boolean isMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	
	


	
}
