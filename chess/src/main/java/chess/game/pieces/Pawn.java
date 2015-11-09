
package chess.game.pieces;

import java.util.List;

import chess.Color;
import chess.game.Square;
import chess.game.rule.BackwardMovementRule;
import chess.game.rule.PawnMovementRule;

public class Pawn extends Piece {

	private boolean movedTwoSquares = false;

	public Pawn() {
		super();
		this.rules.add(new PawnMovementRule(this));
		this.rules.add(new BackwardMovementRule(this));

	}

	public Pawn(Color color) {
		super(color);
	}

	public Pawn(Square square, Color color) {
		super(square, color);
	}

	@Override
	public String toString() {
		return "P[" + color + "]";
	}

	public String toDetailedString() {
		return "Pawn [rules=" + rules + ", square=" + square + ", color=" + color + "]";
	}

	@Override
	public List<Square> getReachableSquares() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isMovedTwoSquares() {
		return movedTwoSquares;
	}

	public void setMovedTwoSquares(boolean movedTwoSquares) {
		this.movedTwoSquares = movedTwoSquares;
	}

}
